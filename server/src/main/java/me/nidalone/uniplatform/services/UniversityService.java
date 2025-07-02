package me.nidalone.uniplatform.services;

import me.nidalone.uniplatform.domain.entities.University;

import java.util.List;

public interface UniversityService {

  List<University> getAllUniversities();

  University getUniversityBySlug(String universitySlug);

  void addNewUniversity(University university);

  void deleteUniversityBySlug(String universitySlug);
}
