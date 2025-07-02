package me.nidalone.uniplatform.exceptions;

public class CourseAlreadyExistsException extends RuntimeException {
  public CourseAlreadyExistsException(String university, String degreeProgram, String exam) {
    super(
        "University \""
            + university
            + "\" already has the course \""
            + exam
            + "\" in the degree program \""
            + degreeProgram
            + "!");
  }
}
