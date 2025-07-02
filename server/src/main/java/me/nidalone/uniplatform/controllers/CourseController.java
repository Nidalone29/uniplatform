package me.nidalone.uniplatform.controllers;

import me.nidalone.uniplatform.domain.dto.CourseCreationDTO;
import me.nidalone.uniplatform.domain.dto.CourseDataDTO;
import me.nidalone.uniplatform.domain.entities.Course;
import me.nidalone.uniplatform.domain.entities.DegreeProgram;
import me.nidalone.uniplatform.mappers.CourseMapper;
import me.nidalone.uniplatform.services.DegreeProgramService;
import me.nidalone.uniplatform.services.CourseService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping(
    path = "/api/universities/{universitySlug}/degree-programs/{degreeProgramSlug}/courses")
public class CourseController {
  private final CourseService courseService;
  private final DegreeProgramService degreeProgramService;

  private final CourseMapper courseMapper;

  public CourseController(
      CourseService courseService,
      DegreeProgramService degreeProgramService,
      CourseMapper courseMapper) {
    this.courseService = courseService;
    this.degreeProgramService = degreeProgramService;
    this.courseMapper = courseMapper;
  }

  /**
   * Get all courses of a degree program
   *
   * @param universitySlug
   * @param degreeProgramSlug
   * @return
   */
  @GetMapping(path = "/")
  public ResponseEntity<List<CourseDataDTO>> getAllCourses(
      @PathVariable String universitySlug, @PathVariable String degreeProgramSlug) {
    return ResponseEntity.ok()
        .body(
            courseService.getAllCourses(universitySlug, degreeProgramSlug).stream()
                .map(courseMapper::toDataDTO)
                .toList());
  }

  /**
   * Get a particular course
   *
   * @param universitySlug
   * @param degreeProgramSlug
   * @param courseSlug
   * @return
   */
  @GetMapping(path = "/{courseSlug}")
  public ResponseEntity<CourseDataDTO> getCourse(
      @PathVariable String universitySlug,
      @PathVariable String degreeProgramSlug,
      @PathVariable String courseSlug) {
    Course res = courseService.getCourse(universitySlug, degreeProgramSlug, courseSlug);
    return ResponseEntity.ok(courseMapper.toDataDTO(res));
  }

  /**
   * @param universitySlug
   * @param degreeProgramSlug
   * @param courseCreationDTO
   * @return
   */
  @PostMapping(path = "/")
  public ResponseEntity<String> addNewCourse(
      @PathVariable String universitySlug,
      @PathVariable String degreeProgramSlug,
      @ModelAttribute CourseCreationDTO courseCreationDTO) {
    DegreeProgram degreeProgram =
        degreeProgramService.getDegreeProgramBySlug(universitySlug, degreeProgramSlug);
    Course course = courseMapper.fromCreationDTO(courseCreationDTO, degreeProgram);
    courseService.addNewCourse(universitySlug, degreeProgramSlug, course);
    String slug = course.getSlug();
    return ResponseEntity.created(
            ServletUriComponentsBuilder.fromCurrentRequestUri()
                .path("/{slug}")
                .buildAndExpand(slug)
                .toUri())
        .build();
  }

  /**
   * @param universitySlug
   * @param degreeProgramSlug
   * @param courseSlug
   * @param courseDataDTO
   * @return
   */
  @PutMapping("/{courseSlug}/update_ects")
  public ResponseEntity<String> updateECTS(
      @PathVariable String universitySlug,
      @PathVariable String degreeProgramSlug,
      @PathVariable String courseSlug,
      @ModelAttribute CourseDataDTO courseDataDTO) {
    courseService.updateCourseECTS(
        universitySlug, degreeProgramSlug, courseSlug, courseDataDTO.ects());
    return ResponseEntity.ok("Course updated successfully!");
  }

  @DeleteMapping("/{courseSlug}")
  public ResponseEntity<String> deleteCourse(
      @PathVariable String universitySlug,
      @PathVariable String degreeProgramSlug,
      @PathVariable String courseSlug) {
    courseService.removeCourse(universitySlug, degreeProgramSlug, courseSlug);
    return ResponseEntity.ok("Course deleted!");
  }
}
