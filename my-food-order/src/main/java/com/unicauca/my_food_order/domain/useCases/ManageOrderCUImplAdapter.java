package com.unicauca.my_food_order.domain.useCases;

import org.springframework.stereotype.Service;
import com.unicauca.my_food_order.application.input.ManageOrderCUInt;
import com.unicauca.my_food_order.application.output.ExceptionFormatterIntPort;
import com.unicauca.my_food_order.application.output.ManageOrderGatewayIntPort;
import com.unicauca.my_food_order.domain.Order;
import com.unicauca.my_food_order.domain.services.OrderDomainService;
import com.unicauca.my_food_order.domain.value_objects.Dish;

@Service
public class ManageOrderCUImplAdapter implements ManageOrderCUInt{
    private final OrderDomainService domainService;
    private final ManageOrderGatewayIntPort gateway;
    private final ExceptionFormatterIntPort formatter;

    public ManageOrderCUImplAdapter(OrderDomainService domainService,
                                    ManageOrderGatewayIntPort gateway ,
                                    ExceptionFormatterIntPort formatter){
        this.domainService = domainService;
        this.gateway = gateway;
        this.formatter = formatter;
    }

    @Override
    public Order createOrder() {
        Order order = new Order();
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
        double totalPrice = this.domainService.calculateTotalPrice(order);
        this.gateway.save(order);
        return totalPrice;
    }
}
