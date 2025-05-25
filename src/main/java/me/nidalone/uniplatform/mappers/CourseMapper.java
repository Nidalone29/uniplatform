package me.nidalone.uniplatform.mappers;

import me.nidalone.uniplatform.domain.dto.CourseDTO;
import me.nidalone.uniplatform.domain.entities.Course;

public interface CourseMapper {

  Course fromDTO(CourseDTO courseDTO);

  CourseDTO toDTO(Course course);
}
