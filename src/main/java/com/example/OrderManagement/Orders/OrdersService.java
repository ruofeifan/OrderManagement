package com.example.OrderManagement.Orders;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
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

    public void deleteOrder(Long orderId) {
        boolean exists = ordersRepository.existsById(orderId);
        if(!exists){
            throw new IllegalStateException("Order with ID " + orderId + " does not exist.");
        }
        ordersRepository.deleteById(orderId);
    }

    @Transactional
    public void updateOrder(Long orderId, Long customerId, String email) {
        //if order does not exist, throw msg.
        Orders existingOrder = ordersRepository.findById(orderId).orElseThrow(
                () -> new IllegalStateException(
                        "Order with ID " + orderId + " does not exist."
                ));
        //Update customerId if provided and different from the existing value
        if(customerId != null && !Objects.equals(existingOrder.getCustomerId(), customerId)){
            existingOrder.setCustomerId(customerId);
        }

        if(email != null && email.length() > 0 && !Objects.equals(existingOrder.getEmail(), email)){
            existingOrder.setEmail(email);
        }
        //ordersRepository.save(existingOrder);
    }
}
