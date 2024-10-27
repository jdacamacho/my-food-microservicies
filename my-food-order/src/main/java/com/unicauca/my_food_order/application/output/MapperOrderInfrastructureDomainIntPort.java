package com.unicauca.my_food_order.application.output;

import java.util.List;

import com.unicauca.my_food_order.domain.Order;
import com.unicauca.my_food_order.infrastructure.input.controller.DTOResponse.OrderDTOResponse;

public interface MapperOrderInfrastructureDomainIntPort {
    public OrderDTOResponse mapModelToResponse(Order model);
    public List<OrderDTOResponse> mapModelToResponse(List<Order> orders);
}
