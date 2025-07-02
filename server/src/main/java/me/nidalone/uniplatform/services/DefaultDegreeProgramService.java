package me.nidalone.uniplatform.services;

import me.nidalone.uniplatform.domain.entities.DegreeProgram;
import me.nidalone.uniplatform.domain.entities.University;
import me.nidalone.uniplatform.exceptions.DegreeProgramAlreadyExistsException;
import me.nidalone.uniplatform.exceptions.DegreeProgramNotFoundException;
import me.nidalone.uniplatform.exceptions.UniversityNotFoundException;
import me.nidalone.uniplatform.repositories.DegreeProgramRepository;
import me.nidalone.uniplatform.repositories.UniversityRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DefaultDegreeProgramService implements DegreeProgramService {
  private final DegreeProgramRepository degreeProgramRepository;
  private final UniversityRepository universityRepository;

  public DefaultDegreeProgramService(
      DegreeProgramRepository degreeProgramRepository, UniversityRepository universityRepository) {
    this.degreeProgramRepository = degreeProgramRepository;
    this.universityRepository = universityRepository;
  }

  @Override
  public DegreeProgram getDegreeProgramBySlug(String universitySlug, String degreeProgramSlug) {
    University university =
        universityRepository
            .findBySlug(universitySlug)
            .orElseThrow(() -> new UniversityNotFoundException(universitySlug));

    return degreeProgramRepository
        .findByUniAndSlug(university, degreeProgramSlug)
        .orElseThrow(() -> new DegreeProgramNotFoundException(universitySlug, degreeProgramSlug));
  }

  @Override
  public List<DegreeProgram> getAllDegreePrograms(String universitySlug) {
    University university =
        universityRepository
            .findBySlug(universitySlug)
            .orElseThrow(() -> new UniversityNotFoundException(universitySlug));
    return university.getDegreePrograms();
  }

  @Override
  public void addDegreeProgram(String universitySlug, DegreeProgram degreeProgram) {
    if (degreeProgram.getName().isEmpty()) {
      throw new IllegalArgumentException();
    }

    if (degreeProgram.getSlug().isEmpty()) {
      // It means that the degreeProgram was created with no parameters somehow
      throw new RuntimeException();
    }

    University university =
        universityRepository
            .findBySlug(universitySlug)
            .orElseThrow(() -> new UniversityNotFoundException(universitySlug));

    Optional<DegreeProgram> c =
        degreeProgramRepository.findByUniAndSlug(university, degreeProgram.getSlug());
    if (c.isPresent()) {
      throw new DegreeProgramAlreadyExistsException(university.getName(), degreeProgram.getName());
    }

    degreeProgramRepository.save(degreeProgram);
  }

  @Override
  public void removeDegreeProgram(String universitySlug, String degreeProgramSlug) {
    University university =
        universityRepository
            .findBySlug(universitySlug)
            .orElseThrow(() -> new UniversityNotFoundException(universitySlug));

    degreeProgramRepository.delete(
        degreeProgramRepository
            .findByUniAndSlug(university, degreeProgramSlug)
            .orElseThrow(
                () -> new DegreeProgramNotFoundException(universitySlug, degreeProgramSlug)));
  }
}
