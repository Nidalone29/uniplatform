package me.nidalone.uniplatform;

public class ExamAlreadyExistsException extends RuntimeException {
  public ExamAlreadyExistsException(String uni, String course, String exam) {
    super("University \"" + uni + "\" already has the exam \"" + exam + "\" in the course \"!");
  }
}
