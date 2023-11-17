package org.Binar.Challenge.service;

import lombok.extern.slf4j.Slf4j;
import org.Binar.Challenge.model.Order;
import org.Binar.Challenge.model.Product;
import org.Binar.Challenge.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

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

    @Transactional(readOnly = true)
    @Override
    public List<Order> getAllOrders(String userId) {
        return orderRepository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Order getOrderDetails(String orderId) {
        log.info("Getting order detail info of {}", orderId);
        return Optional.ofNullable(orderRepository.findById(Long.valueOf(orderId)))
                .map(order->Order.builder()
                        .orderId(order.get().getOrderId())
                        .time(order.get().getTime())
                        .destination(order.get().getDestination())
                        .userId(order.get().getUserId())
                        .build())
                .orElse(null);
    }
}

