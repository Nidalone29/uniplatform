package me.nidalone.uniplatform.controllers;

import me.nidalone.uniplatform.domain.dto.ExamDTO;
import me.nidalone.uniplatform.domain.entities.Exam;
import me.nidalone.uniplatform.mappers.ExamMapper;
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
  private final ExamMapper examMapper;

  public ExamController(ExamService examService, ExamMapper examMapper) {
    this.examService = examService;
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
  public ResponseEntity<List<ExamDTO>> getAllExams(
      @PathVariable String universitySlug, @PathVariable String courseSlug) {
    return ResponseEntity.ok()
        .body(
            examService.getAllExams(universitySlug, courseSlug).stream()
                .map(examMapper::toDTO)
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
  public ResponseEntity<ExamDTO> getExam(
      @PathVariable String universitySlug,
      @PathVariable String courseSlug,
      @PathVariable String examSlug) {
    Exam res = examService.getExam(universitySlug, courseSlug, examSlug);
    return ResponseEntity.ok(examMapper.toDTO(res));
  }

  /**
   * @param universitySlug
   * @param courseSlug
   * @param examName
   * @return
   */
  @PostMapping(path = "/")
  public ResponseEntity<String> addNewExam(
      @PathVariable String universitySlug,
      @PathVariable String courseSlug,
      @RequestParam String examName) {
    examService.addNewExam(universitySlug, courseSlug, examName);
    String slug = SlugUtil.toSlug(examName);
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
