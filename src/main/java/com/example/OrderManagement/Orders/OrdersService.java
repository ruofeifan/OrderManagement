package com.example.OrderManagement.Orders;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrdersService {
    private final OrdersRepository ordersRepository;

    @Autowired
    public OrdersService(OrdersRepository ordersRepository) {
        this.ordersRepository = ordersRepository;
    }

    public List<Orders> getOrder(){
        return ordersRepository.findAll();
    }
    public void addNewOrder(Orders order) {
        Optional<Orders> orderByOrderId = ordersRepository.findOrdersByOrderId(order.getOrderId());
        if(orderByOrderId.isPresent()){
            throw new IllegalStateException("Order exists!");
        }
        ordersRepository.save(order);
    }
}
