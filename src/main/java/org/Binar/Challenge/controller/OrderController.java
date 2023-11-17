package org.Binar.Challenge.controller;

import lombok.extern.slf4j.Slf4j;
import org.Binar.Challenge.model.Order;
import org.Binar.Challenge.model.request.OrderRequest;
import org.Binar.Challenge.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/api/Order")
@Slf4j

public class OrderController {

    @Autowired
    private OrderService orderService;

    // Membuat pesanan
    @PostMapping("/create")
    public ResponseEntity<Order> makeOrder(
            @RequestBody OrderRequest orderRequest
    ) {
        // Anda perlu membuat OrderRequest yang berisi userId, produk, alamat pengiriman, dan tujuan
        Order newOrder = orderService.makeOrder(
                orderRequest.getUserId(),
                orderRequest.getProducts(),
                orderRequest.getShippingAddress(),
                orderRequest.getDestination()
        );
        return ResponseEntity.status(HttpStatus.CREATED).body(newOrder);
    }

    // Menampilkan pesanan
    @GetMapping
    public ResponseEntity<List<Order>> getAllOrders(@RequestParam String userId) {
        List<Order> orders = orderService.getAllOrders(userId);
        if (!orders.isEmpty()) {
            return ResponseEntity.ok(orders);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ArrayList<>());
        }
    }
}
