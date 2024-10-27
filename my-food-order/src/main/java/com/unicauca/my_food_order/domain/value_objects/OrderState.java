package com.unicauca.my_food_order.domain.value_objects;

import com.unicauca.my_food_order.domain.Order;
import com.unicauca.my_food_order.domain.constants.OrderStateConstants;
import com.unicauca.my_food_order.infrastructure.output.exceptionHandler.ownException.BusinessRuleException;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderState {
    private String id_state;
    private String state;
    private Order objOrder;

    public OrderState(){}
    
    public OrderState(int state){
        this.state = this.selectState(state);
    }

    public String selectState(int state){
        if(state == 0)
            return OrderStateConstants.ORDER_STATE_PROCESING;
        else if(state == 1)
            return OrderStateConstants.ORDER_STATE_COMPLETED;
        else if(state == 2)
            return OrderStateConstants.ORDER_STATE_CANCELLED;
        else
            throw new BusinessRuleException("State is no valid...");
    }
}
