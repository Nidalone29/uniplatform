package me.nidalone.uniplatform.controllers;

import java.util.List;

import me.nidalone.uniplatform.domain.dto.CourseCreationDTO;
import me.nidalone.uniplatform.domain.dto.CourseDataDTO;
import me.nidalone.uniplatform.domain.entities.Course;
import me.nidalone.uniplatform.domain.entities.University;
import me.nidalone.uniplatform.mappers.CourseMapper;
import me.nidalone.uniplatform.services.CourseService;
import me.nidalone.uniplatform.services.UniversityService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping(path = "/api/universities/{universitySlug}/courses")
public class CourseController {
  private final CourseService courseService;
  private final UniversityService universityService;

  private final CourseMapper courseMapper;

  public CourseController(
      CourseService courseService, UniversityService universityService, CourseMapper courseMapper) {
    this.courseService = courseService;
    this.universityService = universityService;
    this.courseMapper = courseMapper;
  }

  /**
   * Get all courses of a university
   *
   * @param universitySlug
   * @return
   */
  @GetMapping(path = "/")
  public ResponseEntity<List<CourseDataDTO>> getAllCourses(@PathVariable String universitySlug) {
    return ResponseEntity.ok()
        .body(
            courseService.getAllCourses(universitySlug).stream()
                .map(courseMapper::toDataDTO)
                .toList());
  }

  /**
   * Get a course
   *
   * @param universitySlug
   * @param courseSlug
   * @return
   */
  @GetMapping(path = "/{courseSlug}")
  public ResponseEntity<CourseDataDTO> getCourse(
      @PathVariable String universitySlug, @PathVariable String courseSlug) {
    return ResponseEntity.ok(
        courseMapper.toDataDTO(courseService.getCourseBySlug(universitySlug, courseSlug)));
  }

  /**
   * @param universitySlug
   * @param courseCreationDTO
   * @return
   */
  @PostMapping(path = "/")
  public ResponseEntity<String> addNewCourse(
      @PathVariable String universitySlug, @ModelAttribute CourseCreationDTO courseCreationDTO) {
    University university = universityService.getUniversityBySlug(universitySlug);
    Course course = courseMapper.fromCreationDTO(courseCreationDTO, university);
    courseService.addCourse(universitySlug, course);
    // at this point if there are not any throws the entity has been created
    String slug = course.getSlug();
    return ResponseEntity.created(
            ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{slug}")
                .buildAndExpand(slug)
                .toUri())
        .build();
  }

  @DeleteMapping("/{courseSlug}")
  public ResponseEntity<String> deleteCourse(
      @PathVariable String universitySlug, @PathVariable String courseSlug) {
    courseService.removeCourse(universitySlug, courseSlug);
    return ResponseEntity.ok("Course deleted!");
  }
}
