package com.example.OrderManagement.Orders;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/orders")
//This class will have all the resources for our API
public class OrdersController {
    private final OrdersService ordersService;
    @Autowired
    public OrdersController(OrdersService ordersService) {
        this.ordersService = ordersService;
    }

    @GetMapping
    public List<Orders> getOrder(){
        return ordersService.getOrder();
    }

    @PostMapping
    public void placeNewOrder(@RequestBody Orders order){
        ordersService.addNewOrder(order);
    }
}
