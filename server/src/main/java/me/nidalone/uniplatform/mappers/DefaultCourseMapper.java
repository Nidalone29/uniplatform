package me.nidalone.uniplatform.mappers;

import me.nidalone.uniplatform.domain.dto.CourseCreationDTO;
import me.nidalone.uniplatform.domain.dto.CourseDataDTO;
import me.nidalone.uniplatform.domain.entities.Course;
import me.nidalone.uniplatform.domain.entities.DegreeProgram;
import org.springframework.stereotype.Component;

@Component
public class DefaultCourseMapper implements CourseMapper {

  @Override
  public Course fromCreationDTO(CourseCreationDTO courseCreationDTO, DegreeProgram degreeProgram) {
    return new Course(courseCreationDTO.name(), courseCreationDTO.ects(), degreeProgram);
  }

  @Override
  public CourseDataDTO toDataDTO(Course course) {
    return new CourseDataDTO(course.getName(), course.getSlug(), course.getEcts());
  }
}
