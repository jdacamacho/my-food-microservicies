package com.unicauca.my_food_order.infrastructure.output.formatter;

import org.springframework.stereotype.Service;
import com.unicauca.my_food_order.application.output.ExceptionFormatterIntPort;
import com.unicauca.my_food_order.infrastructure.output.exceptionHandler.ownException.BusinessRuleException;
import com.unicauca.my_food_order.infrastructure.output.exceptionHandler.ownException.NoDataException;
import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;

@Service
public class ExceptionFormatterImplAdapter implements ExceptionFormatterIntPort {
    @Override
    public void responseBusinessRuleViolates(String message) {
        throw new BusinessRuleException(message);
    }

    @Override
    public void responseEntityNotFound(String message) {
        throw new EntityNotFoundException(message);
    }

    @Override
    public void responseEntityExists(String message) {
        throw new EntityExistsException(message);
    }

    @Override
    public void responseNoData(String message) {
        throw new NoDataException(message);
    }
}
