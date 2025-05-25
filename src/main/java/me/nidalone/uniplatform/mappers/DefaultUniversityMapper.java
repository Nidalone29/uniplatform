package me.nidalone.uniplatform.mappers;

import me.nidalone.uniplatform.domain.dto.UniversityDTO;
import me.nidalone.uniplatform.domain.entities.University;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.Optional;

@Component
public class DefaultUniversityMapper implements UniversityMapper {

  private final DefaultCourseMapper dcm;

  public DefaultUniversityMapper(DefaultCourseMapper dcm) {
    this.dcm = dcm;
  }

  @Override
  public University fromDTO(UniversityDTO universityDTO) {
    return new University(
        universityDTO.name(),
        Optional.ofNullable(universityDTO.courses())
            .map(courses -> courses.stream().map(dcm::fromDTO).toList())
            .orElse(Collections.emptyList()));
  }

  @Override
  public UniversityDTO toDTO(University university) {
    return new UniversityDTO(
        university.getName(),
        Optional.ofNullable(university.getCourses())
            .map(courses -> courses.stream().map(dcm::toDTO).toList())
            .orElse(Collections.emptyList()));
  }
}
