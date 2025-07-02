package me.nidalone.uniplatform.exceptions;

public class DegreeProgramNotFoundException extends RuntimeException {
  public DegreeProgramNotFoundException(String university, String degreeProgram) {
    super(
        "Degree Program \"" + degreeProgram + "\" Not Found in university \"" + university + "\"!");
  }
}
