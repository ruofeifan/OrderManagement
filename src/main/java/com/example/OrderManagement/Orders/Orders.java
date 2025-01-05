package com.example.OrderManagement.Orders;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;

@Entity //for Hibernate
@Table //for database
public class Orders {
    @Id
    @SequenceGenerator(
            name = "order_sequence",
            sequenceName = "order_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "order_sequence"
    )

    private Long orderId;
    private Long customerId;
    private String email;
    private LocalDateTime orderDate;
    private String status;
    @Transient
    private Integer orderDays;

    public Orders() {
    }

    public Orders(Long orderId, Long customerId, String email, LocalDateTime orderDate, String status) {
        this.orderId = orderId;
        this.customerId = customerId;
        this.email = email;
        this.orderDate = orderDate;
        this.status = status;
    }

    public Orders(Long customerId, String email, LocalDateTime orderDate, String status) {
        this.customerId = customerId;
        this.email = email;
        this.orderDate = orderDate;
        this.status = status;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getOrderDays() {
        return Period.between(orderDate.toLocalDate(), LocalDate.now()).getDays();
    }

    public void setOrderDays(Integer orderDays) {
        this.orderDays = orderDays;
    }

    @Override
    public String toString() {
        return "Orders{" +
                "orderId=" + orderId +
                ", customerId=" + customerId +
                ", email='" + email + '\'' +
                ", orderDate=" + orderDate +
                ", status='" + status + '\'' +
                ", orderDays=" + orderDays +
                '}';
    }
}
