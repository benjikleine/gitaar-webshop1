package com.example.Gitaar.Webshop.service.Impl;

import com.example.Gitaar.Webshop.domain.Order;
import com.example.Gitaar.Webshop.domain.OrderItem;
import com.example.Gitaar.Webshop.domain.Product;
import com.example.Gitaar.Webshop.repository.OrderItemRepository;
import com.example.Gitaar.Webshop.repository.OrderRepository;
import com.example.Gitaar.Webshop.repository.ProductRepository;
import com.example.Gitaar.Webshop.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final OrderItemRepository orderItemRepository;
    private final ProductRepository productRepository;
    private final MailSender mailSender;

    @Override
    public List<Order> findAll() {
        return orderRepository.findAll();
    }

    @Override
    public Long finalizeOrder() {
        List<Order> orders = orderRepository.findAll();
        Order orderIndex = orders.get(orders.size() - 1);
        return orderIndex.getId();
    }

    @Override
    public List<Order> findOrderByEmail(String email) {
        return orderRepository.findOrderByEmail(email);
    }

    @Override
    public Order postOrder(Order validOrder, Map<Long, Long> productsId) {
        Order order = new Order();
        List<OrderItem> orderItemList = new ArrayList<>();

        for (Map.Entry<Long, Long> entry : productsId.entrySet()) {
            Product product = productRepository.findById(entry.getKey()).get();
            OrderItem orderItem = new OrderItem();
            orderItem.setProduct(product);
            orderItem.setAmount((product.getPrice() * entry.getValue()));
            orderItem.setQuantity(entry.getValue());
            orderItemList.add(orderItem);
            orderItemRepository.save(orderItem);
        }

        order.getOrderItems().addAll(orderItemList);
        order.setTotalPrice(validOrder.getTotalPrice());
        order.setFirstName(validOrder.getFirstName());
        order.setLastName(validOrder.getLastName());
        order.setCity(validOrder.getCity());
        order.setAddress(validOrder.getAddress());
        order.setPostIndex(validOrder.getPostIndex());
        order.setEmail(validOrder.getEmail());
        order.setPhoneNumber(validOrder.getPhoneNumber());
        orderRepository.save(order);

        StringBuilder products = new StringBuilder();
        order.getOrderItems().forEach((orderItem) ->
        {
            products.append(orderItem.getProduct().getCreator());
            products.append(" ");
            products.append(orderItem.getProduct().getProductTitle());
            products.append(" — $");
            products.append(orderItem.getProduct().getPrice());
            products.append(".00 (quantity: ");
            products.append(orderItem.getQuantity());
            products.append(")");
            products.append("\n");
        });

        String subject = "Order #" + order.getId();
        String message = "Hello " + order.getFirstName() + "!\n" +
                "Thank you for your order in Gitaar.Webshop online store.\n" +
                "Your order number is " + order.getId() + "\n" +
                "Date: " + order.getDate() + "\n" +
                "Name: " + order.getFirstName() + " " + order.getLastName() + "\n" +
                "Address: " + order.getCity() + ", " + order.getAddress() + "\n" +
                "Post index: " + order.getPostIndex() + "\n" +
                "Phone: " + order.getPhoneNumber() + "\n\n" +
                "Products: " + "\n" + products + "\n" +
                "Total price: $" + order.getTotalPrice();
        mailSender.send(order.getEmail(), subject, message);
        return order;
    }
}
