package com.example.Gitaar.Webshop.controller;

import com.example.Gitaar.Webshop.dto.AuthenticationRequestDto;
import com.example.Gitaar.Webshop.dto.PasswordResetRequestDto;
import com.example.Gitaar.Webshop.dto.user.UserResponseDto;
import com.example.Gitaar.Webshop.exception.ApiRequestException;
import com.example.Gitaar.Webshop.exception.PasswordConfigException;
import com.example.Gitaar.Webshop.exception.PasswordException;
import com.example.Gitaar.Webshop.mapper.UserMapper;
import com.example.Gitaar.Webshop.utils.ControllerUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/aith")
public class AuthenticationController {

    private final AuthenticationManager authenticationManager;
    private final UserMapper userMapper;

    @PostMapping("/login")
    public ResponseEntity<Map<String, Object>> login(@RequestBody AuthenticationRequestDto request) {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));
            return ResponseEntity.ok(userMapper.login(request.getEmail()));
        } catch (AuthenticationException e) {
            throw new ApiRequestException("Incorrect password or email", HttpStatus.FORBIDDEN);
        }
    }

    @PostMapping("/forgot")
    public ResponseEntity<String> forgotPassword(@RequestBody PasswordResetRequestDto passwordReset) {
        boolean forgotPassword = userMapper.sendPasswordResetCode(passwordReset.getEmail());
        if (!forgotPassword) {
            throw new ApiRequestException("Email not found", HttpStatus.BAD_REQUEST);
        }
        return ResponseEntity.ok("Reset password code is send to your E-mail");
    }

    @GetMapping("/reset/{code}")
    public ResponseEntity<UserResponseDto> getPasswordResetCode(@PathVariable String code) {
        UserResponseDto user = userMapper.findByPasswordResetCode(code);
        if (user == null) {
            throw new ApiRequestException("Password reset code is invalid!", HttpStatus.BAD_REQUEST);
        }
        return ResponseEntity.ok(user);
    }

    @PostMapping("/reset")
    public ResponseEntity<String> passwordReset(@RequestBody PasswordResetRequestDto passwordReset) {
        if (ControllerUtils.isPasswordConfirmEmpty(passwordReset.getPassword2())) {
            throw new PasswordConfigException("Password confirmation cannot be empty.");
        }
        if (ControllerUtils.isPasswordDifferent(passwordReset.getPassword(), passwordReset.getPassword2())) {
            throw new PasswordException("Passwords do not match.");
        }
        userMapper.passwordReset(passwordReset.getEmail(), passwordReset.getPassword());
        return ResponseEntity.ok("Password successfully changed!");
    }
}