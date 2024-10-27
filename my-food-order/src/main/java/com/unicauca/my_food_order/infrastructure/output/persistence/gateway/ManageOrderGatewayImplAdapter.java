package com.unicauca.my_food_order.infrastructure.output.persistence.gateway;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

import com.unicauca.my_food_order.application.output.ManageOrderGatewayIntPort;
import com.unicauca.my_food_order.domain.Order;
import com.unicauca.my_food_order.infrastructure.output.persistence.entities.OrderEntity;
import com.unicauca.my_food_order.infrastructure.output.persistence.repositories.OrderRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ManageOrderGatewayImplAdapter implements ManageOrderGatewayIntPort {
    private final OrderRepository bd;
    private final ModelMapper mapper;

    @Override
    public Order save(Order order) {
        OrderEntity orderEntity = this.mapper.map(order, OrderEntity.class);
        OrderEntity orderSaved = this.bd.save(orderEntity);
        Order response = this.mapper.map(orderSaved, Order.class);
        return response;
    }

    @Override
    public Order findById(String idOrder) {
        OrderEntity order = this.bd.findById(idOrder).get();
        Order response = this.mapper.map(order, Order.class);
        return response;
    }

    @Override
    public boolean existsById(String idOrder) {
        return this.bd.existsById(idOrder);
    }

    @Override
    public List<Order> findAll() {
        List<OrderEntity> orders = this.bd.findAll();
        List<Order> response = this.mapper.map(orders, new TypeToken<List<Order>>(){}.getType());
        return response;
    }

}
