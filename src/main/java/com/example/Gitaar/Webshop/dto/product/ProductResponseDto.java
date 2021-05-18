package com.example.Gitaar.Webshop.dto.product;

import com.example.Gitaar.Webshop.dto.review.ReviewResponseDto;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Data
public class ProductResponseDto {

    private Long id;
    private String productTitle;
    private String creator;
    private Integer year;
    private String country;
    private String fragranceTopNotes;
    private String fragranceMiddleNotes;
    private String fragranceBaseNotes;
    private String description;
    private String filename;
    private Integer price;
    private String color;
    private String type;
    private List<ReviewResponseDto> reviews;
    private MultipartFile file;
}
