package com.example.Gitaar.Webshop.dto.product;

import lombok.Data;

import java.util.List;

@Data
public class ProductSearchRequestDto {

    private List<String> creators;
    private List<Integer> prices;
    private String creator;
}
