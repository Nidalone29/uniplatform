package me.nidalone.uniplatform.mappers;

import me.nidalone.uniplatform.domain.dto.ExamCreationDTO;
import me.nidalone.uniplatform.domain.dto.ExamDataDTO;
import me.nidalone.uniplatform.domain.entities.Course;
import me.nidalone.uniplatform.domain.entities.Exam;
import org.springframework.stereotype.Component;

@Component
public class DefaultExamMapper implements ExamMapper {

  @Override
  public Exam fromCreationDTO(ExamCreationDTO examCreationDTO, Course course) {
    return new Exam(examCreationDTO.name(), examCreationDTO.ects(), course);
  }

  @Override
  public ExamDataDTO toDataDTO(Exam exam) {
    return new ExamDataDTO(exam.getName(), exam.getSlug(), exam.getEcts());
  }
}
