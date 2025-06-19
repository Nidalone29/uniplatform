package me.nidalone.uniplatform.mappers;

import me.nidalone.uniplatform.domain.dto.ExamCreationDTO;
import me.nidalone.uniplatform.domain.dto.ExamDataDTO;
import me.nidalone.uniplatform.domain.entities.Course;
import me.nidalone.uniplatform.domain.entities.Exam;

public interface ExamMapper {

  Exam fromCreationDTO(ExamCreationDTO examCreationDTO, Course course);

  ExamDataDTO toDataDTO(Exam exam);
}
