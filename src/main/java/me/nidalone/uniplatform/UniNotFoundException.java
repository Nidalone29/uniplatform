package me.nidalone.uniplatform;

public class UniNotFoundException extends RuntimeException {
  public UniNotFoundException(String uni) {
    super("University \"" + uni + "\" Not Found!");
  }
}
