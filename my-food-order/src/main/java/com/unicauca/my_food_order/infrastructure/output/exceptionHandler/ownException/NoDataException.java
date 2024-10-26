package com.unicauca.my_food_order.infrastructure.output.exceptionHandler.ownException;

import com.unicauca.my_food_order.infrastructure.output.exceptionHandler.exceptionStructure.ErrorCode;

import lombok.Getter;

@Getter
public class NoDataException extends RuntimeException{
    private final String mesageKey;
    private final String code;

    public NoDataException(ErrorCode code){
        super(code.getCode());
        this.mesageKey = code.getMessageKey();
        this.code = code.getCode();
    }

    public NoDataException(final String message){
        super(message);
        this.mesageKey = ErrorCode.NO_DATA.getMessageKey();
        this.code = ErrorCode.NO_DATA.getCode();
    }
}

