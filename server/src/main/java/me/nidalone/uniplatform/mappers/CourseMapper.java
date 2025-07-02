package me.nidalone.uniplatform.mappers;

import me.nidalone.uniplatform.domain.dto.CourseCreationDTO;
import me.nidalone.uniplatform.domain.dto.CourseDataDTO;
import me.nidalone.uniplatform.domain.entities.Course;
import me.nidalone.uniplatform.domain.entities.University;

public interface CourseMapper {

  Course fromCreationDTO(CourseCreationDTO courseCreationDTO, University university);

  CourseDataDTO toDataDTO(Course course);
}
