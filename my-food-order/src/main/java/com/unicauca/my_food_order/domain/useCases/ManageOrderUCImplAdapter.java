package com.unicauca.my_food_order.domain.useCases;

import java.util.List;

import com.unicauca.my_food_order.application.input.ManageOrderUCIntPort;
import com.unicauca.my_food_order.application.output.ExceptionFormatterIntPort;
import com.unicauca.my_food_order.application.output.ManageOrderGatewayIntPort;
import com.unicauca.my_food_order.domain.Order;
import com.unicauca.my_food_order.domain.services.OrderDomainService;
import com.unicauca.my_food_order.domain.value_objects.Dish;

public class ManageOrderUCImplAdapter implements ManageOrderUCIntPort{
    private final OrderDomainService domainService;
    private final ManageOrderGatewayIntPort gateway;
    private final ExceptionFormatterIntPort formatter;

    public ManageOrderUCImplAdapter(OrderDomainService domainService,
                                    ManageOrderGatewayIntPort gateway ,
                                    ExceptionFormatterIntPort formatter){
        this.domainService = domainService;
        this.gateway = gateway;
        this.formatter = formatter;
    }

    @Override
    public List<Order> getOrders() {
        return this.gateway.findAll();
    }

    @Override
    public Order getOrder(String idOrder) {
        if(!this.gateway.existsById(idOrder))
            formatter.responseEntityNotFound("entity not found...");
        
        return this.gateway.findById(idOrder);
    }

    @Override
    public Order createOrder() {
        Order order = new Order();
        order.getDate().setObjOrder(order);
        order.getState().setObjOrder(order);
        order.getTotalPrice().setObjOrder(order);
        Order response = this.gateway.save(order);
        return response;
    }

    @Override
    public Order addDish(String idOrder, String dishName, double dishValue) {
        if(!this.gateway.existsById(idOrder))
            formatter.responseEntityNotFound("entity not found...");

        Order order = this.gateway.findById(idOrder);
        Dish dish = new Dish(dishName, dishValue);

        this.domainService.addDish(order, dish);
        
        Order response = this.gateway.save(order);
        return response;
    }

    @Override
    public Order removeDish(String idOrder, String idDish) {
        Order order = null;
        if(!this.gateway.existsById(idOrder))
            formatter.responseEntityNotFound("entity not found...");
        
        order = this.gateway.findById(idOrder);
        boolean flag = this.domainService.removeDish(order, idDish);

        if(flag){
            Order response = this.gateway.save(order);
            return response;
        }

        this.formatter.responseEntityNotFound("Dish was not found...");
        return order;
    }

    @Override
    public Order updateOrderState(String idOrder, int state) {
        Order order = null;
        if(!this.gateway.existsById(idOrder))
            formatter.responseEntityNotFound("entity not found...");

        order = this.gateway.findById(idOrder);
        boolean flag = this.domainService.changeOrderState(order, state);

        if(flag){
            order.getState().setObjOrder(order);
            Order response = this.gateway.save(order);
            return response;
        }

        this.formatter.responseBusinessRuleViolates("State is not valid...");
        return order;
    }

    @Override
    public double calculateOrderTotalPrice(String idOrder) {
        if(!this.gateway.existsById(idOrder))
            formatter.responseEntityNotFound("entity not found...");
        
        Order order = this.gateway.findById(idOrder);
        order.getTotalPrice().setObjOrder(order);
        double totalPrice = this.domainService.calculateTotalPrice(order);
        this.gateway.save(order);
        return totalPrice;
    }
}
