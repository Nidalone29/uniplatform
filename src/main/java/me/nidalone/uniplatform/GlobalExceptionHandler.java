package me.nidalone.uniplatform;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalExceptionHandler {

  @ResponseBody
  @ExceptionHandler(UniNotFoundException.class)
  @ResponseStatus(HttpStatus.NOT_FOUND)
  String uniNotFoundHandler(UniNotFoundException ex) {
    return ex.getMessage();
  }

  @ResponseBody
  @ExceptionHandler(CourseNotFoundException.class)
  @ResponseStatus(HttpStatus.NOT_FOUND)
  String corsoNotFoundHandler(CourseNotFoundException ex) {
    return ex.getMessage();
  }

  @ResponseBody
  @ExceptionHandler(ExamNotFoundException.class)
  @ResponseStatus(HttpStatus.NOT_FOUND)
  String esameNotFoundHandler(ExamNotFoundException ex) {
    return ex.getMessage();
  }

  @ResponseBody
  @ExceptionHandler(UniAlreadyExistsException.class)
  @ResponseStatus(HttpStatus.FORBIDDEN)
  String uniAlreadyExistsException(UniAlreadyExistsException ex) {
    return ex.getMessage();
  }

  @ResponseBody
  @ExceptionHandler(CourseAlreadyExistsException.class)
  @ResponseStatus(HttpStatus.FORBIDDEN)
  String corsoAlreadyExistsException(CourseAlreadyExistsException ex) {
    return ex.getMessage();
  }

  @ResponseBody
  @ExceptionHandler(ExamAlreadyExistsException.class)
  @ResponseStatus(HttpStatus.FORBIDDEN)
  String esameAlreadyExistsException(ExamAlreadyExistsException ex) {
    return ex.getMessage();
  }
}
