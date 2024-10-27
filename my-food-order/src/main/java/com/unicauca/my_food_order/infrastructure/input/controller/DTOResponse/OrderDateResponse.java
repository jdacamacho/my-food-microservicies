package com.unicauca.my_food_order.infrastructure.input.controller.DTOResponse;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class OrderDateResponse {
    private String id_date;
    private String date;
    private String hour;

    public OrderDateResponse(){
        
    }
}
