package com.unicauca.my_food_order.infrastructure.input;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

public class ErrorCatcher {
    public ErrorCatcher(){
        
    }

    public Map<String, Object> catchErrors(BindingResult result) {
        Map<String, Object> response = new HashMap<>();
        if (result.hasErrors()) {
            List<String> errors = new ArrayList<>();

            for (FieldError error : result.getFieldErrors()) {
                errors.add("The field '" + error.getField() + "‘ " + error.getDefaultMessage());
            }
            response.put("errors", errors);
        }
        return response;

    }
}
