package com.example.OrderManagement.Orders;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public class Order {
    private long orderId;
    private long customerId;
    private LocalDateTime orderDate;
    private String status;
    private String paymentMethod;
    private String paymentStatus;
    private BigDecimal totalAmount;
    private String shippingAddress;
    private LocalDateTime deliveryDate;
    private String shippingMethod;
    private String trackingNumber;
    private List<OrderItem> items;

    public Order() {
    }

    public Order(long orderId, long customerId, LocalDateTime orderDate, String status) {
        this.orderId = orderId;
        this.customerId = customerId;
        this.orderDate = orderDate;
        this.status = status;
    }

    public Order(long customerId, LocalDateTime orderDate, String status) {
        this.customerId = customerId;
        this.orderDate = orderDate;
        this.status = status;
    }

    public long getOrderId() {
        return orderId;
    }

    public long getCustomerId() {
        return customerId;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public List<OrderItem> getItems() {
        return items;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public String getTrackingNumber() {
        return trackingNumber;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", customerId=" + customerId +
                ", orderDate=" + orderDate +
                ", status='" + status + '\'' +
                ", paymentMethod='" + paymentMethod + '\'' +
                ", paymentStatus='" + paymentStatus + '\'' +
                ", totalAmount=" + totalAmount +
                ", shippingAddress='" + shippingAddress + '\'' +
                ", deliveryDate=" + deliveryDate +
                ", shippingMethod='" + shippingMethod + '\'' +
                ", trackingNumber='" + trackingNumber + '\'' +
                ", items=" + items +
                '}';
    }
}
