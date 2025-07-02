package me.nidalone.uniplatform.exceptions;

public class UniversityAlreadyExistsException extends RuntimeException {
  public UniversityAlreadyExistsException(String uni) {
    super("University \"" + uni + "\" is already present!");
  }
}
