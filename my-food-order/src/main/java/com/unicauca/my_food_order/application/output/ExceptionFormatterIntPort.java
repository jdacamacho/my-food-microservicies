package com.unicauca.my_food_order.application.output;

public interface ExceptionFormatterIntPort {
    public void responseBusinessRuleViolates(String message);
    public void responseEntityNotFound(String message);
    public void responseEntityExists(String message);
    public void responseNoData(String message);
}
