package com.example.Gitaar.Webshop.controller;

import com.example.Gitaar.Webshop.dto.order.OrderResponseDto;
import com.example.Gitaar.Webshop.dto.product.ProductRequestDto;
import com.example.Gitaar.Webshop.dto.product.ProductResponseDto;
import com.example.Gitaar.Webshop.dto.user.UserRequestDto;
import com.example.Gitaar.Webshop.dto.user.UserResponseDto;
import com.example.Gitaar.Webshop.exception.InputFieldException;
import com.example.Gitaar.Webshop.mapper.OrderMapper;
import com.example.Gitaar.Webshop.mapper.ProductMapper;
import com.example.Gitaar.Webshop.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@PreAuthorize("hasAuthority('ADMIN')")
@RequestMapping("/api/v1/admin")
public class AdminController {

    private final UserMapper userMapper;
    private final ProductMapper productMapper;
    private final OrderMapper orderMapper;

    @PostMapping("/add")
    public ResponseEntity<ProductResponseDto> addProduct(@RequestPart(name = "file", required = false) MultipartFile file,
                                                         @RequestPart("product") @Valid ProductRequestDto product,
                                                         BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new InputFieldException(bindingResult);
        } else {
            return ResponseEntity.ok(productMapper.saveProduct(product, file));
        }
    }

    @PutMapping("/edit")
    public ResponseEntity<ProductResponseDto> updateProduct(@RequestPart(name = "file", required = false) MultipartFile file,
                                                            @RequestPart("product") @Valid ProductRequestDto product,
                                                            BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new InputFieldException(bindingResult);
        } else {
            return ResponseEntity.ok(productMapper.saveProduct(product, file));
        }
    }

    @GetMapping("/orders")
    public ResponseEntity<List<OrderResponseDto>> getAllOrders() {
        return ResponseEntity.ok(orderMapper.findAllOrders());
    }

    @PostMapping("/order")
    public ResponseEntity<List<OrderResponseDto>> getUserOrdersByEmail(@RequestBody UserRequestDto user) {
        return ResponseEntity.ok(orderMapper.findOrderByEmail(user.getEmail()));
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<UserResponseDto> getUser(@PathVariable("id") Long userId) {
        return ResponseEntity.ok(userMapper.findUserById(userId));
    }

    @GetMapping("/user/all")
    public ResponseEntity<List<UserResponseDto>> getAllUsers() {
        return ResponseEntity.ok(userMapper.findAllUsers());
    }

    @PutMapping("/user/edit")
    public ResponseEntity<String> updateUser(@RequestParam String username,
                                             @RequestParam Map<String, String> form,
                                             @RequestParam("userId") UserRequestDto userDto) {
        userMapper.userSave(username, form, userDto);
        return ResponseEntity.ok("User updated successfully.");
    }
}
