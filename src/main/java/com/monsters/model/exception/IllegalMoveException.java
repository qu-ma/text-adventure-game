package com.monsters.model.exception;

public class IllegalMoveException extends IllegalArgumentException{

  public IllegalMoveException(String message){
    super(message);
  }

  public IllegalMoveException(Throwable cause){
    super(cause);
  }

  public IllegalMoveException(String message, Throwable cause){
    super(message, cause);
  }

}
