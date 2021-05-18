package com.example.Gitaar.Webshop.service;

import com.example.Gitaar.Webshop.domain.Order;

import java.util.List;
import java.util.Map;

public interface OrderService {

    List<Order> findAll();

    List<Order> findOrderByEmail(String email);

    Order postOrder(Order validOrder, Map<Long, Long> productsId);

    Long finalizeOrder();
}
