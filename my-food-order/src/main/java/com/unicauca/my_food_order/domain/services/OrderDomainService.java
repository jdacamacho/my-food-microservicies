package com.unicauca.my_food_order.domain.services;

import com.unicauca.my_food_order.domain.Order;
import com.unicauca.my_food_order.domain.value_objects.Dish;
import com.unicauca.my_food_order.domain.value_objects.Ingredient;
import com.unicauca.my_food_order.infrastructure.output.exceptionHandler.ownException.BusinessRuleException;
import com.unicauca.my_food_order.infrastructure.output.exceptionHandler.ownException.ObjectNullException;

public class OrderDomainService implements IOrderDomainService{
    private final int MAX_STATE_AVAIBLE = 3;

    public OrderDomainService(){}

    @Override
    public boolean changeOrderState(Order order, int state) {
        if(state < 0)
            throw new BusinessRuleException("State must be major or equals than zero...");

        if(state > MAX_STATE_AVAIBLE)
            throw new BusinessRuleException("State is not valid...");
        
        if(order == null)
            throw new ObjectNullException("Order is null...");
        
        return order.changeState(state);
    }

    @Override
    public boolean addDish(Order order, Dish dish) {
        if(order == null)
            throw new ObjectNullException("Order is null...");

        if(dish == null)
            throw new ObjectNullException("Dish is null...");
        
        return order.addDish(dish);
    }

    @Override
    public boolean removeDish(Order order, String idDish) {
        if(order == null)
            throw new ObjectNullException("Order is null...");

        if(idDish.isBlank())
            throw new ObjectNullException("Dish's id is null...");
        
        return order.removeDish(idDish);
    }

    @Override
    public boolean addIngredient(Dish dish, Ingredient ingredient) {
        if(dish == null)
            throw new ObjectNullException("Dish is null...");
        
        if(ingredient == null)
            throw new ObjectNullException("Ingredient is null...");
        
        return dish.addIngredient(ingredient);
    }

    @Override
    public boolean removeIngredient(Dish dish, String idIngredient) {
        if(dish == null)
            throw new ObjectNullException("Dish is null...");
        
        if(idIngredient.isBlank())
            throw new ObjectNullException("Ingredient's id is null...");
        
        return dish.removeIngredient(idIngredient);
    }

    @Override
    public String getOrderDate(Order order) {
        if(order == null)
            throw new ObjectNullException("Order is null...");

        return order.getDate().getDate();
    }

    @Override
    public String getOrderHour(Order order) {
        if(order == null)
            throw new ObjectNullException("Order is null...");

        return order.getDate().getHour();
    }

    @Override
    public double calculateTotalPrice(Order order) {
        if(order == null)
            throw new ObjectNullException("Order is null...");

        return order.getTotalPrice().calculateTotalPrice(order.getDishes());
    }
}

