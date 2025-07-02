package me.nidalone.uniplatform.exceptions;

public class CourseAlreadyExistsException extends RuntimeException {
  public CourseAlreadyExistsException(String uni, String course) {
    super("University \"" + uni + "\" already has \"" + course);
  }
}
