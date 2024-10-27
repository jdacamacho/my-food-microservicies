package com.unicauca.my_food_order.application.output;

import java.util.List;

import com.unicauca.my_food_order.domain.Order;

public interface ManageOrderGatewayIntPort {
    public Order save(Order order);
    public Order findById(String idOrder);
    public boolean existsById(String idOrder);
    public List<Order> findAll();
}
