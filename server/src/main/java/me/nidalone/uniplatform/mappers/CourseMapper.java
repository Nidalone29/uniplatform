package me.nidalone.uniplatform.mappers;

import me.nidalone.uniplatform.domain.dto.CourseCreationDTO;
import me.nidalone.uniplatform.domain.dto.CourseDataDTO;
import me.nidalone.uniplatform.domain.entities.Course;
import me.nidalone.uniplatform.domain.entities.DegreeProgram;

public interface CourseMapper {

  Course fromCreationDTO(CourseCreationDTO courseCreationDTO, DegreeProgram degreeProgram);

  CourseDataDTO toDataDTO(Course course);
}
