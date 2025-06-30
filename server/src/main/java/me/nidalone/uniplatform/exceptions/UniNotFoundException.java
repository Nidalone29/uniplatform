package me.nidalone.uniplatform.exceptions;

public class UniNotFoundException extends RuntimeException {
  public UniNotFoundException(String uni) {
    super("University \"" + uni + "\" Not Found!");
  }
}
