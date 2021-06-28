package com.example.Gitaar.Webshop.mapper;

import com.example.Gitaar.Webshop.domain.Product;
import com.example.Gitaar.Webshop.dto.product.ProductRequestDto;
import com.example.Gitaar.Webshop.dto.product.ProductResponseDto;
import com.example.Gitaar.Webshop.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class ProductMapper {

    private final ModelMapper modelMapper;
    private final ProductService productService;

    private Product convertToEntity(ProductRequestDto productRequestDto) {
        return modelMapper.map(productRequestDto, Product.class);
    }

    private ProductResponseDto convertToResponseDto(Product product) {
        return modelMapper.map(product, ProductResponseDto.class);
    }

    List<ProductResponseDto> convertListToResponseDto(List<Product> products) {
        return products.stream()
                .map(this::convertToResponseDto)
                .collect(Collectors.toList());
    }

    public ProductResponseDto findProductById(Long productId) {
        return convertToResponseDto(productService.findProductById(productId));
    }

    public List<ProductResponseDto> findAllProducts() {
        return convertListToResponseDto(productService.findAllProducts());
    }

    public List<ProductResponseDto> findByCreatorOrderByPriceDesc(String creator) {
        return convertListToResponseDto(productService.findByCreatorOrderByPriceDesc(creator));
    }

    public ProductResponseDto saveProduct(ProductRequestDto productRequestDto, MultipartFile file) {
        return convertToResponseDto(productService.saveProduct(convertToEntity(productRequestDto), file));
    }

}
