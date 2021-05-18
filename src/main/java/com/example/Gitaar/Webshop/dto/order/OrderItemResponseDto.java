package com.example.Gitaar.Webshop.dto.order;

import com.example.Gitaar.Webshop.repository.ProductRepository;
import lombok.Data;

@Data
public class OrderItemResponseDto {

    private Long id;
    private Long amount;
    private Long quantity;
    private ProductRepository product;
}
