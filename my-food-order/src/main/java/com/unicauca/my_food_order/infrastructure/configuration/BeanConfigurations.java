package com.unicauca.my_food_order.infrastructure.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.unicauca.my_food_order.domain.services.OrderDomainService;
import com.unicauca.my_food_order.infrastructure.input.ErrorCatcher;

@Configuration
public class BeanConfigurations {
    
    @Bean
    public OrderDomainService createOrderCU(){
        return new OrderDomainService();
    }

    @Bean
    public ErrorCatcher createErrorCatcher(){
        return new ErrorCatcher();
    }
}
