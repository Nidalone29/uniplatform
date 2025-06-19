package me.nidalone.uniplatform.controllers;

import me.nidalone.uniplatform.domain.dto.ExamCreationDTO;
import me.nidalone.uniplatform.domain.dto.ExamDataDTO;
import me.nidalone.uniplatform.domain.entities.Course;
import me.nidalone.uniplatform.domain.entities.Exam;
import me.nidalone.uniplatform.mappers.ExamMapper;
import me.nidalone.uniplatform.services.CourseService;
import me.nidalone.uniplatform.services.ExamService;
import me.nidalone.uniplatform.utils.SlugUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping(path = "/api/universities/{universitySlug}/courses/{courseSlug}/exams")
public class ExamController {
  private final ExamService examService;
  private final CourseService courseService;

  private final ExamMapper examMapper;

  public ExamController(
      ExamService examService, CourseService courseService, ExamMapper examMapper) {
    this.examService = examService;
    this.courseService = courseService;
    this.examMapper = examMapper;
  }

  /**
   * Get all exams of a course
   *
   * @param universitySlug
   * @param courseSlug
   * @return
   */
  @GetMapping(path = "/")
  public ResponseEntity<List<ExamDataDTO>> getAllExams(
      @PathVariable String universitySlug, @PathVariable String courseSlug) {
    return ResponseEntity.ok()
        .body(
            examService.getAllExams(universitySlug, courseSlug).stream()
                .map(examMapper::toDataDTO)
                .toList());
  }

  /**
   * Get a particular exam
   *
   * @param universitySlug
   * @param courseSlug
   * @param examSlug
   * @return
   */
  @GetMapping(path = "/{examSlug}")
  public ResponseEntity<ExamDataDTO> getExam(
      @PathVariable String universitySlug,
      @PathVariable String courseSlug,
      @PathVariable String examSlug) {
    Exam res = examService.getExam(universitySlug, courseSlug, examSlug);
    return ResponseEntity.ok(examMapper.toDataDTO(res));
  }

  /**
   * @param universitySlug
   * @param courseSlug
   * @param examCreationDTO
   * @return
   */
  @PostMapping(path = "/")
  public ResponseEntity<String> addNewExam(
      @PathVariable String universitySlug,
      @PathVariable String courseSlug,
      @ModelAttribute ExamCreationDTO examCreationDTO) {
    Course course = courseService.getCourseBySlug(universitySlug, courseSlug);
    Exam exam = examMapper.fromCreationDTO(examCreationDTO, course);
    examService.addNewExam(universitySlug, courseSlug, exam);
    String slug = exam.getSlug();
    return ResponseEntity.created(
            ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{slug}")
                .buildAndExpand(slug)
                .toUri())
        .build();
  }

  /**
   * @param universitySlug
   * @param courseSlug
   * @param examSlug
   * @param ects
   * @return
   */
  @PutMapping("/{examSlug}/update_ects")
  public ResponseEntity<String> updateECTS(
      @PathVariable String universitySlug,
      @PathVariable String courseSlug,
      @PathVariable String examSlug,
      @RequestParam int ects) {
    examService.updateExamECTS(universitySlug, courseSlug, examSlug, ects);
    return ResponseEntity.ok("Exam updated successfully!");
  }

  @DeleteMapping("/{examSlug}")
  public ResponseEntity<String> deleteExam(
      @PathVariable String universitySlug,
      @PathVariable String courseSlug,
      @PathVariable String examSlug) {
    examService.removeExam(universitySlug, courseSlug, examSlug);
    return ResponseEntity.ok("Exam deleted!");
  }
}
