package com.example.Gitaar.Webshop.controller;

import com.example.Gitaar.Webshop.dto.RegistrationRequestDto;
import com.example.Gitaar.Webshop.exception.ApiRequestException;
import com.example.Gitaar.Webshop.exception.EmailException;
import com.example.Gitaar.Webshop.exception.InputFieldException;
import com.example.Gitaar.Webshop.exception.PasswordException;
import com.example.Gitaar.Webshop.mapper.UserMapper;
import com.example.Gitaar.Webshop.utils.ControllerUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/registration")
public class RegistrationController {

    @Value("${recaptcha.secret}")
    private String secret;

    private final UserMapper userMapper;
    private final RestTemplate restTemplate;

    @PostMapping
    public ResponseEntity<String> registration(@Valid @RequestBody RegistrationRequestDto user, BindingResult bindingResult) {
        ControllerUtils.captchaValidation(secret, user.getCaptcha(), restTemplate);

        if (ControllerUtils.isPasswordDifferent(user.getPassword(), user.getPassword2())) {
            throw new PasswordException("Passwords do not match.");
        }
        if (bindingResult.hasErrors()) {
            throw new InputFieldException(bindingResult);
        }
        if (!userMapper.registerUser(user)) {
            throw new EmailException("Email is already used.");
        }
        return ResponseEntity.ok("User successfully registered.");
    }

    @GetMapping("/activate/{code}")
    public ResponseEntity<String> activateEmailCode(@PathVariable String code) {
        if (!userMapper.activateUser(code)) {
            throw new ApiRequestException("Activation code not found.", HttpStatus.NOT_FOUND);
        } else {
            return ResponseEntity.ok("User successfully activated.");
        }
    }
}
