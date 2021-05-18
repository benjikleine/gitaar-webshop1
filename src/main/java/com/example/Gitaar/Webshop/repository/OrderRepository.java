package com.example.Gitaar.Webshop.repository;

import com.example.Gitaar.Webshop.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

    List<Order> findOrderByEmail(String email);
}
