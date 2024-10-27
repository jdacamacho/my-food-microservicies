package com.unicauca.my_food_order.infrastructure.input.controller.DTOResponse;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class OrderStateDTOResponse {
    private String id_state;
    private String state;

    public OrderStateDTOResponse(){
        
    }
}
