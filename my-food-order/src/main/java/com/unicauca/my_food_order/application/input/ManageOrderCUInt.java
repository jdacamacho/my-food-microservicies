package com.unicauca.my_food_order.application.input;

import com.unicauca.my_food_order.domain.Order;

public interface ManageOrderCUInt {
    public Order createOrder();
    public Order addDish(String idOrder, String dishName, double dishValue);
    public Order removeDish(String idOrder, String idDish);
    public Order updateOrderState(String idOrder, int state);
    public double calculateOrderTotalPrice(String idOrder);
}
