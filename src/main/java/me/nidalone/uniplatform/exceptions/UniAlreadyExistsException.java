package me.nidalone.uniplatform.exceptions;

public class UniAlreadyExistsException extends RuntimeException {
  public UniAlreadyExistsException(String uni) {
    super("University \"" + uni + "\" is already present!");
  }
}
