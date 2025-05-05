package me.nidalone.uniplatform;

public class CourseNotFoundException extends RuntimeException {
  public CourseNotFoundException(String course) {
    super("Course \"" + course + "\" Not Found!");
  }
}
