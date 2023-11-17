package org.Binar.Challenge.controller;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.Binar.Challenge.model.Order;
import org.Binar.Challenge.model.request.OrderRequest;
import org.Binar.Challenge.service.OrderService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.Date;

public class OrderControllerTest {

    @InjectMocks
    private OrderController orderController;

    @Mock
    private OrderService orderService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testMakeOrder() {
        // Buat objek order yang akan digunakan dalam pengujian
        OrderRequest orderRequest = new OrderRequest("userId", new ArrayList<>(), "shippingAddress", "destination");
        Order newOrder = new Order(1L, new Date(), "destination", "userId", "completed");
        when(orderService.makeOrder(
                        orderRequest.getUserId(),
                        orderRequest.getProducts(),
                        orderRequest.getShippingAddress(),
                        orderRequest.getDestination()))
                .thenReturn(newOrder);

        // Panggil metode yang akan diuji
        ResponseEntity<Order> response = orderController.makeOrder(orderRequest);

        // Verifikasi bahwa respon sesuai dengan yang diharapkan
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(newOrder, response.getBody());
    }
}
