package me.nidalone.uniplatform.controllers;

import java.util.List;

import me.nidalone.uniplatform.domain.dto.CourseDTO;
import me.nidalone.uniplatform.mappers.CourseMapper;
import me.nidalone.uniplatform.services.CourseService;
import me.nidalone.uniplatform.utils.SlugUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping(path = "/api/universities/{universitySlug}/courses")
public class CourseController {
  private final CourseService courseService;
  private final CourseMapper courseMapper;

  public CourseController(CourseService courseService, CourseMapper courseMapper) {
    this.courseService = courseService;
    this.courseMapper = courseMapper;
  }

  /**
   * Get all courses of a university
   *
   * @param universitySlug
   * @return
   */
  @GetMapping(path = "/")
  public ResponseEntity<List<CourseDTO>> getAllCourses(@PathVariable String universitySlug) {
    return ResponseEntity.ok()
        .body(
            courseService.getAllCourses(universitySlug).stream().map(courseMapper::toDTO).toList());
  }

  /**
   * Get a course
   *
   * @param universitySlug
   * @param courseSlug
   * @return
   */
  @GetMapping(path = "/{courseSlug}")
  public ResponseEntity<CourseDTO> getCourse(
      @PathVariable String universitySlug, @PathVariable String courseSlug) {
    return ResponseEntity.ok(
        courseMapper.toDTO(courseService.getCourse(universitySlug, courseSlug)));
  }

  /**
   * @param universitySlug
   * @param courseName
   * @return
   */
  @PostMapping(path = "/")
  public ResponseEntity<String> addNewCourse(
      @PathVariable String universitySlug, @RequestParam String courseName) {
    courseService.addCourse(universitySlug, courseName);
    String slug = SlugUtil.toSlug(courseName);
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
