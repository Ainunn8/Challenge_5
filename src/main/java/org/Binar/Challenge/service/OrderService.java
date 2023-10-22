package org.Binar.Challenge.service;

import org.Binar.Challenge.model.Order;
import org.Binar.Challenge.model.Product;

import java.util.List;

public interface OrderService {
    // Membuat pesanan baru
    Order makeOrder(String userId, List<Product> products, String shippingAddress, String destination);

    // Menampilkan semua pesanan
    List<Order> getAllOrders(String userId);
}
