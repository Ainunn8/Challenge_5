package org.Binar.Challenge.repository;

import org.Binar.Challenge.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
