package com.unicauca.my_food_order.infrastructure.exceptionHandler.ownException;

import com.unicauca.my_food_order.infrastructure.exceptionHandler.exceptionStructure.ErrorCode;
import lombok.Getter;

@Getter
public class ObjectNullException extends RuntimeException{
  private final String messageKey;
  private final String code;

  public ObjectNullException(ErrorCode code){
    super(code.getCode());
    this.messageKey = code.getMessageKey();
    this.code = code.getCode();
  }

  public ObjectNullException(final String message){
    super(message);
    this.messageKey = ErrorCode.OBJECT_NULL.getMessageKey();
    this.code = ErrorCode.OBJECT_NULL.getCode();
  }
}
