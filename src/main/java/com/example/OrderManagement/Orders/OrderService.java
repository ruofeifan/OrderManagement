package com.example.OrderManagement.Orders;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class OrderService {

    private final Map<Long, Order> orderStore = new HashMap<>();
    private long orderIdCounter = 1;

    // Create a new order
    public Order createOrder(Order order) {
        order.setStatus(order.getStatus() != null ? order.getStatus() : "PENDING");
        order.setOrderId(orderIdCounter++);
        orderStore.put(order.getOrderId(), order);
        return order;
    }

    // Get order by ID
    public Order getOrderById(long orderId) {
        Order order = orderStore.get(orderId);
        if (order == null) {
            throw new IllegalArgumentException("Order not found with ID: " + orderId);
        }
        return order;
    }

    // Get all orders
    public List<Order> getAllOrders() {
        return new ArrayList<>(orderStore.values());
    }

    // Update an order
    public Order updateOrder(long orderId, Order updatedOrder) {
        if (!orderStore.containsKey(orderId)) {
            throw new IllegalArgumentException("Order not found with ID: " + orderId);
        }
        updatedOrder.setOrderId(orderId); // Ensure the ID remains unchanged
        orderStore.put(orderId, updatedOrder);
        return updatedOrder;
    }

    // Delete an order
    public void deleteOrder(long orderId) {
        if (!orderStore.containsKey(orderId)) {
            throw new IllegalArgumentException("Order not found with ID: " + orderId);
        }
        orderStore.remove(orderId);
    }
}
