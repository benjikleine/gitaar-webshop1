package com.example.Gitaar.Webshop.mapper;

import com.example.Gitaar.Webshop.domain.Order;
import com.example.Gitaar.Webshop.dto.order.OrderRequestDto;
import com.example.Gitaar.Webshop.dto.order.OrderResponseDto;
import com.example.Gitaar.Webshop.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class OrderMapper {

    private final ModelMapper modelMapper;
    private final OrderService orderService;

    private Order convertToEntity(OrderRequestDto orderRequestDto) {
        return modelMapper.map(orderRequestDto, Order.class);
    }

    private OrderResponseDto convertToResponseDto(Order order) {
        return modelMapper.map(order, OrderResponseDto.class);
    }

    public List<OrderResponseDto> findAllOrders() {
        return orderService.findAll()
                .stream()
                .map(this::convertToResponseDto)
                .collect(Collectors.toList());
    }

    public List<OrderResponseDto> findOrderByEmail(String email) {
        return orderService.findOrderByEmail(email)
                .stream()
                .map(this::convertToResponseDto)
                .collect(Collectors.toList());
    }

    public Long finalizeOrder() {
        return orderService.finalizeOrder();
    }

    public OrderResponseDto postOrder(OrderRequestDto orderRequestDto) {
        return convertToResponseDto(orderService.postOrder(convertToEntity(orderRequestDto),
                orderRequestDto.getProductsId()));
    }
}
