package com.example.Gitaar.Webshop.dto.review;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class ReviewRequestDto {

    private Long productId;

    @NotBlank(message = "Fill in the input field")
    private String author;

    @NotBlank(message = "Fill in the input field")
    private String message;
}
