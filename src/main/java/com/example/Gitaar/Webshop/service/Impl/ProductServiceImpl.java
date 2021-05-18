package com.example.Gitaar.Webshop.service.Impl;

import com.example.Gitaar.Webshop.domain.Product;
import com.example.Gitaar.Webshop.repository.ProductRepository;
import com.example.Gitaar.Webshop.service.ProductService;
import graphql.schema.DataFetcher;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    @Value("${upload.path}")
    private String uploadPath;
    private final ProductRepository productRepository;

    @Override
    public DataFetcher<Product> getProductByQuery() {
        return dataFetchingEnvironment -> {
            Long productId = Long.parseLong(dataFetchingEnvironment.getArgument("id"));
            return productRepository.findById(productId).get();
        };
    }

    @Override
    public DataFetcher<List<Product>> getAllProductsByQuery() {
        return dataFetchingEnvironment -> productRepository.findAll();
    }

    @Override
    public Product findProductById(Long productId) {
        return productRepository.findById(productId).get();
    }

    @Override
    public List<Product> findAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public List<Product> findByCreatorOrderByPriceDesc(String creator) {
        return productRepository.findByCreatorOrderByPriceDesc(creator);
    }

    @Override
    public Product saveProduct(Product product, MultipartFile file) {
        if (file == null && product.getFilename() != null) {
            return productRepository.save(product);
        } else if (file == null || product.getFilename() == null) {
            product.setFilename("empty.jpg");
        } else {
            File uploadDir = new File(uploadPath);

            if (!uploadDir.exists()) {
                uploadDir.mkdir();
            }
            String uuidFile = UUID.randomUUID().toString();
            String resultFilename = uuidFile + "." + file.getOriginalFilename();

            try {
                file.transferTo(new File(uploadPath + "/" + resultFilename));
            } catch (IOException e) {
                e.printStackTrace();
            }
            product.setFilename(resultFilename);
        }
        return productRepository.save(product);
    }
}
