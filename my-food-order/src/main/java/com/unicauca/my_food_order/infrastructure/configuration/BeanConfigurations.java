package com.unicauca.my_food_order.infrastructure.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.unicauca.my_food_order.application.output.ExceptionFormatterIntPort;
import com.unicauca.my_food_order.application.output.ManageOrderGatewayIntPort;
import com.unicauca.my_food_order.domain.services.OrderDomainService;
import com.unicauca.my_food_order.domain.useCases.ManageOrderCUImplAdapter;
import com.unicauca.my_food_order.infrastructure.input.ErrorCatcher;

@Configuration
public class BeanConfigurations {
    
    @Bean
    public OrderDomainService createOrderDomainService(){
        return new OrderDomainService();
    }
    
    @Bean
    public ManageOrderCUImplAdapter createOrderCU(OrderDomainService domainService,
                                                ManageOrderGatewayIntPort gateway,
                                                ExceptionFormatterIntPort formatter){
        return new ManageOrderCUImplAdapter(domainService, gateway, formatter);
    }

    @Bean
    public ErrorCatcher createErrorCatcher(){
        return new ErrorCatcher();
    }
}
