package org.Binar.Challenge.service;

import lombok.extern.slf4j.Slf4j;
import org.Binar.Challenge.model.Order;
import org.Binar.Challenge.model.Product;
import org.Binar.Challenge.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }


    @Override
    public Order makeOrder(String userId, List<Product> products, String shippingAddress, String destination) {
        return null;
    }

    @Override
    public List<Order> getAllOrders(String userId) {
        return orderRepository.findAll();
    }
}

