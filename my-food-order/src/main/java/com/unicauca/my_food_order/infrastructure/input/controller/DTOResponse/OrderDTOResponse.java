package com.unicauca.my_food_order.infrastructure.input.controller.DTOResponse;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class OrderDTOResponse {
    private String id_order;
    private OrderDateResponse date;
    private OrderStateDTOResponse state;
    private List<DishDTOResponse> dishes;
    private TotalPriceDTOResponse totalPrice;  

    public OrderDTOResponse(){

    }
}
