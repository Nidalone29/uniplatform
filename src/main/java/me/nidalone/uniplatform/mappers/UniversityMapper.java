package me.nidalone.uniplatform.mappers;

import me.nidalone.uniplatform.domain.dto.UniversityDTO;
import me.nidalone.uniplatform.domain.entities.University;

public interface UniversityMapper {

  University fromDTO(UniversityDTO universityDTO);

  UniversityDTO toDTO(University university);
}
