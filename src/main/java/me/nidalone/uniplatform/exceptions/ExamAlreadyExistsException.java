package me.nidalone.uniplatform.exceptions;

public class ExamAlreadyExistsException extends RuntimeException {
  public ExamAlreadyExistsException(String uni, String course, String exam) {
    super("University \"" + uni + "\" already has the exam \"" + exam + "\" in the course \"!");
  }
}
