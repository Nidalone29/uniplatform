package me.nidalone.uniplatform.services;

import me.nidalone.uniplatform.domain.entities.DegreeProgram;

import java.util.List;

public interface DegreeProgramService {

  DegreeProgram getDegreeProgramBySlug(String universitySlug, String degreeProgramSlug);

  List<DegreeProgram> getAllDegreePrograms(String universitySlug);

  void addDegreeProgram(String universitySlug, DegreeProgram degreeProgram);

  void removeDegreeProgram(String universitySlug, String degreeProgramSlug);
}
