package me.nidalone.uniplatform.mappers;

import me.nidalone.uniplatform.domain.dto.DegreeProgramCreationDTO;
import me.nidalone.uniplatform.domain.dto.DegreeProgramDataDTO;
import me.nidalone.uniplatform.domain.entities.DegreeProgram;
import me.nidalone.uniplatform.domain.entities.University;

public interface DegreeProgramMapper {

  DegreeProgram fromCreationDTO(
      DegreeProgramCreationDTO degreeProgramCreationDTO, University university);

  DegreeProgramDataDTO toDataDTO(DegreeProgram degreeProgram);
}
