package me.nidalone.uniplatform.services;

import me.nidalone.uniplatform.domain.dto.UniversityCreationDTO;
import me.nidalone.uniplatform.domain.dto.UniversityDataDTO;
import me.nidalone.uniplatform.domain.entities.University;

import java.util.List;

public interface UniversityService {

  List<UniversityDataDTO> getAllUniversities();

  UniversityDataDTO getUniversityBySlug(String universitySlug);

  /**
   * @param university
   * @return it returns the slug of the created entity
   */
  String addNewUniversity(UniversityCreationDTO university);

  void deleteUniversityBySlug(String universitySlug);
}
