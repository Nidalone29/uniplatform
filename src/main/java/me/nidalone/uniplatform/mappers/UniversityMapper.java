package me.nidalone.uniplatform.mappers;

import me.nidalone.uniplatform.domain.dto.UniversityCreationDTO;
import me.nidalone.uniplatform.domain.dto.UniversityDataDTO;
import me.nidalone.uniplatform.domain.entities.University;

public interface UniversityMapper {

  University fromCreationDTO(UniversityCreationDTO universityCreationDTO);

  UniversityDataDTO toDataDTO(University university);
}
