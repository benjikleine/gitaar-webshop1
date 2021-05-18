package com.example.Gitaar.Webshop.repository;

import com.example.Gitaar.Webshop.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findByPriceBetweenOrderByPriceDesc(Integer startingPrice, Integer endingPrice);

    List<Product> findByCreatorOrderByPriceDesc(String Creator);

    List<Product> findByIdIn(List<Long> productsIds);
}
