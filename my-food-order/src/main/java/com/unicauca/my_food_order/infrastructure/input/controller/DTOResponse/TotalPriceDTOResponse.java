package com.unicauca.my_food_order.infrastructure.input.controller.DTOResponse;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TotalPriceDTOResponse {
    private String id_total_price;
    private double totalPrice;

    public TotalPriceDTOResponse(){
        
    }
}
