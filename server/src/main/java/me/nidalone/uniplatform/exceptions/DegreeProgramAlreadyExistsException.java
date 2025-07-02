package me.nidalone.uniplatform.exceptions;

public class DegreeProgramAlreadyExistsException extends RuntimeException {
  public DegreeProgramAlreadyExistsException(String university, String degreeProgram) {
    super("University \"" + university + "\" already has \"" + degreeProgram);
  }
}
