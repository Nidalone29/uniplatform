package me.nidalone.uniplatform.services;

import me.nidalone.uniplatform.domain.dto.DegreeProgramCreationDTO;
import me.nidalone.uniplatform.domain.dto.DegreeProgramDataDTO;

import java.util.List;

public interface DegreeProgramService {

  DegreeProgramDataDTO getDegreeProgramBySlug(String universitySlug, String degreeProgramSlug);

  List<DegreeProgramDataDTO> getAllDegreePrograms(String universitySlug);

  String addDegreeProgram(String universitySlug, DegreeProgramCreationDTO degreeProgramCreationDTO);

  void removeDegreeProgram(String universitySlug, String degreeProgramSlug);
}
