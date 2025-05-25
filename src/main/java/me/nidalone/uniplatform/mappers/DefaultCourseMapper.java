package me.nidalone.uniplatform.mappers;

import me.nidalone.uniplatform.domain.dto.CourseDTO;
import me.nidalone.uniplatform.domain.entities.Course;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.Optional;

@Component
public class DefaultCourseMapper implements CourseMapper {

  private final DefaultExamMapper dem;

  public DefaultCourseMapper(DefaultExamMapper dem) {
    this.dem = dem;
  }

  @Override
  public Course fromDTO(CourseDTO courseDTO) {
    return new Course(
        courseDTO.name(),
        Optional.ofNullable(courseDTO.exams())
            .map(exams -> exams.stream().map(dem::fromDTO).toList())
            .orElse(Collections.emptyList()),
        null);
  }

  @Override
  public CourseDTO toDTO(Course course) {
    return new CourseDTO(
        course.getName(),
        Optional.ofNullable(course.getExams())
            .map(exams -> exams.stream().map(dem::toDTO).toList())
            .orElse(Collections.emptyList()));
  }
}
