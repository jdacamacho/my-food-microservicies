package com.unicauca.my_food_order.infrastructure.output.mapper;

import java.util.List;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

import com.unicauca.my_food_order.application.output.MapperOrderInfrastructureDomainIntPort;
import com.unicauca.my_food_order.domain.Order;
import com.unicauca.my_food_order.infrastructure.input.controller.DTOResponse.OrderDTOResponse;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MapperOrderInfrastructureDomainImplAdapter implements MapperOrderInfrastructureDomainIntPort {
    private final ModelMapper mapper;

    @Override
    public OrderDTOResponse mapModelToResponse(Order model) {
        return this.mapper.map(model, OrderDTOResponse.class);
    }

    @Override
    public List<OrderDTOResponse> mapModelToResponse(List<Order> orders) {
        return this.mapper.map(orders, new TypeToken<List<OrderDTOResponse>>(){}.getType());
    }
}
