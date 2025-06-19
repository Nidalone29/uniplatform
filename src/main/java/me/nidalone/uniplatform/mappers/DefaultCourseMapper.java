package me.nidalone.uniplatform.mappers;

import me.nidalone.uniplatform.domain.dto.CourseCreationDTO;
import me.nidalone.uniplatform.domain.dto.CourseDataDTO;
import me.nidalone.uniplatform.domain.entities.Course;
import me.nidalone.uniplatform.domain.entities.University;
import org.springframework.stereotype.Component;

@Component
public class DefaultCourseMapper implements CourseMapper {

  @Override
  public Course fromCreationDTO(CourseCreationDTO courseCreationDTO, University university) {
    return new Course(courseCreationDTO.name(), university);
  }

  @Override
  public CourseDataDTO toDataDTO(Course course) {
    return new CourseDataDTO(course.getName(), course.getSlug());
  }
}
