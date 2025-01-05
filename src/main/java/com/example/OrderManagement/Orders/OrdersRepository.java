package com.example.OrderManagement.Orders;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OrdersRepository
        extends JpaRepository<Orders, Long> {
//    @Query("SELECT o FROM Order o WHERE o.orderId = ?1")
    Optional<Orders> findOrdersByOrderId(Long orderId);

}
