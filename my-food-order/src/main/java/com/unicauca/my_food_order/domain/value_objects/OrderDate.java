package com.unicauca.my_food_order.domain.value_objects;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderDate {
    private String id_date;
    private String date;
    private String hour;

    public OrderDate(){
        createOrderDate();
        createOrderHour();
    }
    
    private void createOrderDate(){
        LocalDate myDate = LocalDate.now();
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        this.date = myDate.format(dateFormatter);
    }   

    private void createOrderHour(){
        LocalTime myHour = LocalTime.now();
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss"); 
        this.hour = myHour.format(timeFormatter);
    }
}