package me.nidalone.uniplatform;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api")
public class MainController {
  @Autowired //
  private UniRepository uniRepository;

  /**
   * Show a particular university
   *
   * @param UniversityID The university ID as a string
   * @return University object if found, otherwise throw UniversityNotFoundException
   */
  @GetMapping(path = "/{UniversityID}")
  public University getUniversity(@PathVariable String UniversityID) {
    return uniRepository
        .findById(UniversityID)
        .orElseThrow(() -> new UniNotFoundException(UniversityID));
  }

  /**
   * @return All universities present in the database
   */
  @GetMapping(path = "/")
  public Iterable<University> getAllUniversities() {
    return uniRepository.findAll();
  }

  /**
   * Add a new university to the database by name
   *
   * @param name University name to add
   * @return Success message or throw UniAlreadyExistsException
   */
  @PostMapping(path = "/add")
  public String addNewUniversity(@RequestParam String name) {
    Optional<University> res = uniRepository.findById(name);
    if (res.isEmpty()) {
      uniRepository.save(new University(name));
      return "University \"" + name + "\" added successfully!";
    }
    throw new UniAlreadyExistsException(name);
  }

  /**
   * Get the list of exams
   *
   * @param universityID
   * @param courseID
   * @return
   */
  @GetMapping(path = "/api/{universityID}/{courseID}")
  public Iterable<Exam> getCourseExams(
      @PathVariable String universityID, @PathVariable String courseID) {
    return uniRepository
        .findById(universityID)
        .orElseThrow(() -> new UniNotFoundException(universityID))
        .findCourse(courseID)
        .orElseThrow(() -> new CourseNotFoundException(courseID))
        .getExams();
  }

  @GetMapping("/api/{universityID}/{courseID}/{examID}")
  public Exam getExam(
      @PathVariable String universityID,
      @PathVariable String courseID,
      @PathVariable String examID) {
    return uniRepository
        .findById(universityID)
        .orElseThrow(() -> new UniNotFoundException(universityID))
        .findCourse(courseID)
        .orElseThrow(() -> new CourseNotFoundException(courseID))
        .findExam(examID)
        .orElseThrow(() -> new ExamNotFoundException(courseID, examID));
  }
}
