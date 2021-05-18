package com.example.Gitaar.Webshop.controller;

import com.example.Gitaar.Webshop.dto.GraphQLRequestDto;
import com.example.Gitaar.Webshop.dto.product.ProductRequestDto;
import com.example.Gitaar.Webshop.dto.product.ProductResponseDto;
import com.example.Gitaar.Webshop.mapper.ProductMapper;
import graphql.ExecutionResult;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/products")
public class ProductController {

    private final ProductMapper productMapper;

    @GetMapping
    public ResponseEntity<List<ProductResponseDto>> getAllProducts() {
        return ResponseEntity.ok(productMapper.findAllProducts());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductResponseDto> getProduct(@PathVariable("id") Long productId) {
        return ResponseEntity.ok(productMapper.findProductById(productId));
    }

    @PostMapping("/search/purchaser")
    public ResponseEntity<List<ProductResponseDto>> findByCreator(@RequestBody ProductRequestDto filter) {
        return ResponseEntity.ok(productMapper.findByCreatorOrderByPriceDesc(filter.getCreator()));
    }

    @PostMapping("/graphql/products")
    public ResponseEntity<ExecutionResult> getAllProductsByQuery(@RequestBody GraphQLRequestDto request) {
        return ResponseEntity.ok(productMapper.getAllProductsByQuery(request.getQuery()));
    }

    @PostMapping("/graphql/product")
    public ResponseEntity<ExecutionResult> getProductByQuery(@RequestBody GraphQLRequestDto request) {
        return ResponseEntity.ok(productMapper.getProductByQuery(request.getQuery()));
    }
}
