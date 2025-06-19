package me.nidalone.uniplatform.services;

import me.nidalone.uniplatform.domain.entities.University;
import me.nidalone.uniplatform.exceptions.UniAlreadyExistsException;
import me.nidalone.uniplatform.exceptions.UniNotFoundException;
import me.nidalone.uniplatform.repositories.UniversityRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DefaultUniversityService implements UniversityService {
  private final UniversityRepository universityRepository;

  public DefaultUniversityService(UniversityRepository universityRepository) {
    this.universityRepository = universityRepository;
  }

  @Override
  public List<University> getAllUniversities() {
    return universityRepository.findAll();
  }

  @Override
  public University getUniversityBySlug(String universitySlug) {
    return universityRepository
        .findBySlug(universitySlug)
        .orElseThrow(() -> new UniNotFoundException(universitySlug));
  }

  @Override
  public void addNewUniversity(University university) {
    if (university.getName().isEmpty()) {
      throw new IllegalArgumentException();
    }

    if (university.getSlug().isEmpty()) {
      // It means that the university was created with no parameters somehow
      throw new RuntimeException();
    }

    Optional<University> uni = universityRepository.findBySlug(university.getSlug());
    if (uni.isPresent()) {
      throw new UniAlreadyExistsException(university.getName());
    }

    universityRepository.save(university);
  }

  @Override
  public void deleteUniversityBySlug(String universitySlug) {
    University uni =
        universityRepository
            .findBySlug(universitySlug)
            .orElseThrow(() -> new UniNotFoundException(universitySlug));

    universityRepository.delete(uni);
  }
}
