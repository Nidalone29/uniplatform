package me.nidalone.uniplatform.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalExceptionHandler {
  @ResponseBody
  @ExceptionHandler(UniversityNotFoundException.class)
  @ResponseStatus(HttpStatus.NOT_FOUND)
  String universityNotFoundHandler(UniversityNotFoundException ex) {
    return ex.getMessage();
  }

  @ResponseBody
  @ExceptionHandler(DegreeProgramNotFoundException.class)
  @ResponseStatus(HttpStatus.NOT_FOUND)
  String degreeProgramNotFoundHandler(DegreeProgramNotFoundException ex) {
    return ex.getMessage();
  }

  @ResponseBody
  @ExceptionHandler(CourseNotFoundException.class)
  @ResponseStatus(HttpStatus.NOT_FOUND)
  String courseNotFoundHandler(CourseNotFoundException ex) {
    return ex.getMessage();
  }

  @ResponseBody
  @ExceptionHandler(UniversityAlreadyExistsException.class)
  @ResponseStatus(HttpStatus.FORBIDDEN)
  String universityAlreadyExistsException(UniversityAlreadyExistsException ex) {
    return ex.getMessage();
  }

  @ResponseBody
  @ExceptionHandler(DegreeProgramAlreadyExistsException.class)
  @ResponseStatus(HttpStatus.FORBIDDEN)
  String degreeProgramAlreadyExistsException(DegreeProgramAlreadyExistsException ex) {
    return ex.getMessage();
  }

  @ResponseBody
  @ExceptionHandler(CourseAlreadyExistsException.class)
  @ResponseStatus(HttpStatus.FORBIDDEN)
  String courseAlreadyExistsException(CourseAlreadyExistsException ex) {
    return ex.getMessage();
  }
}
