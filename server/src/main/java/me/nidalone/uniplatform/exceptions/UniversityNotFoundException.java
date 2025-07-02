package me.nidalone.uniplatform.exceptions;

public class UniversityNotFoundException extends RuntimeException {
  public UniversityNotFoundException(String uni) {
    super("University \"" + uni + "\" Not Found!");
  }
}
