package com.monsters.model.exception;

public class GameFinishedException extends IllegalStateException {

  //NOTE this looks like overloading. May only need final constructor for Game class.
  public GameFinishedException(String message){
    super(message);
  }

  public GameFinishedException(Throwable cause){
    super(cause);
  }

  public GameFinishedException(String message, Throwable cause){
    super(message, cause);
  }

}
