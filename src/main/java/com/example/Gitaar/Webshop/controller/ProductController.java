package com.example.Gitaar.Webshop.controller;

import com.example.Gitaar.Webshop.dto.product.ProductResponseDto;
import com.example.Gitaar.Webshop.dto.product.ProductSearchRequestDto;
import com.example.Gitaar.Webshop.mapper.ProductMapper;
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
    public ResponseEntity<ProductResponseDto> getProducts(@PathVariable("id") Long productId) {
        return ResponseEntity.ok(productMapper.findProductById(productId));
    }

    @PostMapping("/search/creator")
    public ResponseEntity<List<ProductResponseDto>> findByCreator(@RequestBody ProductSearchRequestDto filter) {
        return ResponseEntity.ok(productMapper.findByCreatorOrderByPriceDesc(filter.getCreator()));
    }
}
