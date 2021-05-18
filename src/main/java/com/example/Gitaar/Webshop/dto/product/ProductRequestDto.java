package com.example.Gitaar.Webshop.dto.product;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class ProductRequestDto {

    private Long id;
    private String filename;

    @NotBlank(message = "Fill in the input field")
    @Length(max = 255)
    private String productTitle;

    @NotBlank(message = "Fill in the input field")
    @Length(max = 255)
    private String creator;

    @NotNull(message = "Fill in the input field")
    private Integer year;

    @NotBlank(message = "Fill in the input field")
    @Length(max = 255)
    private String country;

    @NotBlank(message = "Fill in the input field")
    @Length(max = 255)
    private String fragranceTopNotes;

    @NotBlank(message = "Fill in the input field")
    @Length(max = 255)
    private String fragranceMiddleNotes;

    @NotBlank(message = "Fill in the input field")
    @Length(max = 255)
    private String fragranceBaseNotes;

    @NotNull(message = "Fill in the input field")
    private Integer price;

    @NotBlank(message = "Fill in the input field")
    @Length(max = 255)
    private String color;

    @NotBlank(message = "Fill in the input field")
    @Length(max = 255)
    private String type;
}
