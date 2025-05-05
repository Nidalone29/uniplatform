package me.nidalone.uniplatform;

public class CourseAlreadyExistsException extends RuntimeException {
  public CourseAlreadyExistsException(String uni, String course) {
    super("University \"" + uni + "\" already has \"" + course);
  }
}
