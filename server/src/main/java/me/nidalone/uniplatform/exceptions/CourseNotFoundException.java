package me.nidalone.uniplatform.exceptions;

public class CourseNotFoundException extends RuntimeException {
  public CourseNotFoundException(String university, String degreeProgram, String course) {
    super(
        "Course \""
            + course
            + "\" in Not Found in the degree program \""
            + degreeProgram
            + "\" for university \""
            + university
            + "\"!");
  }
}
