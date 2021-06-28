package com.example.Gitaar.Webshop.controller;

import com.example.Gitaar.Webshop.dto.PasswordResetRequestDto;
import com.example.Gitaar.Webshop.dto.order.OrderRequestDto;
import com.example.Gitaar.Webshop.dto.order.OrderResponseDto;
import com.example.Gitaar.Webshop.dto.product.ProductResponseDto;
import com.example.Gitaar.Webshop.dto.review.ReviewRequestDto;
import com.example.Gitaar.Webshop.dto.user.UserRequestDto;
import com.example.Gitaar.Webshop.dto.user.UserResponseDto;
import com.example.Gitaar.Webshop.exception.InputFieldException;
import com.example.Gitaar.Webshop.exception.PasswordException;
import com.example.Gitaar.Webshop.mapper.OrderMapper;
import com.example.Gitaar.Webshop.mapper.UserMapper;
import com.example.Gitaar.Webshop.utils.ControllerUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/users")
public class UserController {

    private final UserMapper userMapper;
    private final OrderMapper orderMapper;

    @GetMapping("/info")
    public ResponseEntity<UserResponseDto> getUserInfo(@AuthenticationPrincipal UserPrincipal user) {
        return ResponseEntity.ok(userMapper.findUserByEmail(user.getEmail()));
    }

    @PutMapping("/edit")
    public ResponseEntity<UserResponseDto> updateUserInfo(@AuthenticationPrincipal UserPrincipal user,
                                                          @Valid @RequestBody UserRequestDto request,
                                                          BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new InputFieldException(bindingResult);
        } else {
            return ResponseEntity.ok(userMapper.updateProfile(user.getEmail(), request));
        }
    }

    @PutMapping("/edit/password")
    public ResponseEntity<String> updateUserPassword(@AuthenticationPrincipal UserPrincipal user,
                                                     @Valid @RequestBody PasswordResetRequestDto passwordReset,
                                                     BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new InputFieldException(bindingResult);
        } else if (ControllerUtils.isPasswordDifferent(passwordReset.getPassword(), passwordReset.getPassword2())) {
            throw new PasswordException("Passwords do not match.");
        } else {
            userMapper.passwordReset(user.getEmail(), passwordReset.getPassword());
            return ResponseEntity.ok("Password successfully changed!");
        }
    }

    @PostMapping("/cart")
    public ResponseEntity<List<ProductResponseDto>> getCart(@RequestBody List<Long> productsIds) {
        return ResponseEntity.ok(userMapper.getCart(productsIds));
    }

    @GetMapping("/orders")
    public ResponseEntity<List<OrderResponseDto>> getAllUserOrders(@AuthenticationPrincipal UserPrincipal user) {
        return ResponseEntity.ok(orderMapper.findOrderByEmail(user.getEmail()));
    }

    @PostMapping("/order")
    public ResponseEntity<OrderResponseDto> postOrder(@Valid @RequestBody OrderRequestDto order, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new InputFieldException(bindingResult);
        } else {
            return ResponseEntity.ok(orderMapper.postOrder(order));
        }
    }

    @GetMapping("/order/finalize")
    public ResponseEntity<Long> finalizeOrder() {
        return ResponseEntity.ok(orderMapper.finalizeOrder());
    }

    @PostMapping("/review")
    public ResponseEntity<String> addReviewToPerfume(@Valid @RequestBody ReviewRequestDto review, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new InputFieldException(bindingResult);
        } else {
            userMapper.addReviewToProduct(review, review.getProductId());
            return ResponseEntity.ok("Review added successfully.");
        }
    }
}
