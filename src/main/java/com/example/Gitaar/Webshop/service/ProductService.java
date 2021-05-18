package com.example.Gitaar.Webshop.service;

import com.example.Gitaar.Webshop.domain.Product;
import graphql.schema.DataFetcher;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ProductService {

    DataFetcher<Product> getProductByQuery();

    DataFetcher<List<Product>> getAllProductsByQuery();

    Product findProductById(Long productId);

    List<Product> findAllProducts();

    List<Product> findByCreatorOrderByPriceDesc(String creator);

    Product saveProduct(Product product, MultipartFile file);
}
