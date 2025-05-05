package me.nidalone.uniplatform;

public class ExamNotFoundException extends RuntimeException {
  public ExamNotFoundException(String course, String exam) {
    super("Exam \"" + exam + "\" in not found in the degree course \"" + course + "\"!");
  }
}
