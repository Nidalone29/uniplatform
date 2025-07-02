package me.nidalone.uniplatform.exceptions;

public class CourseNotFoundException extends RuntimeException {
  public CourseNotFoundException(String course) {
    super("Course \"" + course + "\" Not Found!");
  }
}
