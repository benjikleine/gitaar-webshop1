package com.example.Gitaar.Webshop.dto.review;

import lombok.Data;

import java.time.LocalDate;

@Data
public class ReviewResponseDto {

    private Long id;
    private String author;
    private String message;
    private LocalDate date;
}
