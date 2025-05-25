package me.nidalone.uniplatform.mappers;

import me.nidalone.uniplatform.domain.dto.ExamDTO;
import me.nidalone.uniplatform.domain.entities.Exam;

public interface ExamMapper {

  Exam fromDTO(ExamDTO examDTO);

  ExamDTO toDTO(Exam exam);
}
