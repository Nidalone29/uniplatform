package me.nidalone.uniplatform.mappers;

import me.nidalone.uniplatform.domain.dto.ExamDTO;
import me.nidalone.uniplatform.domain.entities.Exam;
import org.springframework.stereotype.Component;

@Component
public class DefaultExamMapper implements ExamMapper {

  @Override
  public Exam fromDTO(ExamDTO examDTO) {

    return new Exam(examDTO.name(), examDTO.ects(), null);
  }

  @Override
  public ExamDTO toDTO(Exam exam) {
    if (exam == null) {
      return null;
    }

    return new ExamDTO(exam.getName(), exam.getEcts());
  }
}
