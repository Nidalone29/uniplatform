package me.nidalone.uniplatform.mappers;

import me.nidalone.uniplatform.domain.dto.DegreeProgramCreationDTO;
import me.nidalone.uniplatform.domain.dto.DegreeProgramDataDTO;
import me.nidalone.uniplatform.domain.entities.DegreeProgram;
import me.nidalone.uniplatform.domain.entities.University;
import org.springframework.stereotype.Component;

@Component
public class DefaultDegreeProgramMapper implements DegreeProgramMapper {

  @Override
  public DegreeProgram fromCreationDTO(
      DegreeProgramCreationDTO degreeProgramCreationDTO, University university) {
    return new DegreeProgram(
        degreeProgramCreationDTO.name(), degreeProgramCreationDTO.type(), university);
  }

  @Override
  public DegreeProgramDataDTO toDataDTO(DegreeProgram degreeProgram) {
    return new DegreeProgramDataDTO(
        degreeProgram.getName(), degreeProgram.getSlug(), degreeProgram.getType());
  }
}
