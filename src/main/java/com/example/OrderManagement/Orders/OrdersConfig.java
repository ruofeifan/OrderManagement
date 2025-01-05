package com.example.OrderManagement.Orders;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;
import java.util.List;

@Configuration
public class OrdersConfig {
    @Bean
    CommandLineRunner commandLineRunner(OrdersRepository repository){
        return args -> {
            Orders order1 = new Orders(
                    3L,
                    "xxx@gmail.com",
                    LocalDateTime.of(2023,8,2,18,36,24),
                    "Completed");
            Orders order2 = new Orders(
                    4L,
                    "xxx@gmail.com",
                    LocalDateTime.now(),
                    "Placed");
            repository.save(order1);
            repository.save(order2);
        };
    }
}
