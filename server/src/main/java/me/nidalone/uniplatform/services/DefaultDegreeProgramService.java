package me.nidalone.uniplatform.services;

import me.nidalone.uniplatform.domain.dto.DegreeProgramCreationDTO;
import me.nidalone.uniplatform.domain.dto.DegreeProgramDataDTO;
import me.nidalone.uniplatform.domain.entities.DegreeProgram;
import me.nidalone.uniplatform.domain.entities.University;
import me.nidalone.uniplatform.domain.enums.DegreeProgramType;
import me.nidalone.uniplatform.exceptions.DegreeProgramAlreadyExistsException;
import me.nidalone.uniplatform.exceptions.DegreeProgramNotFoundException;
import me.nidalone.uniplatform.exceptions.UniversityNotFoundException;
import me.nidalone.uniplatform.mappers.DegreeProgramMapper;
import me.nidalone.uniplatform.repositories.DegreeProgramRepository;
import me.nidalone.uniplatform.repositories.UniversityRepository;
import me.nidalone.uniplatform.utils.SlugUtil;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DefaultDegreeProgramService implements DegreeProgramService {
  private final DegreeProgramRepository degreeProgramRepository;
  private final UniversityRepository universityRepository;
  private final DegreeProgramMapper degreeProgramMapper;

  public DefaultDegreeProgramService(
      DegreeProgramRepository degreeProgramRepository,
      UniversityRepository universityRepository,
      DegreeProgramMapper degreeProgramMapper) {
    this.degreeProgramRepository = degreeProgramRepository;
    this.universityRepository = universityRepository;
    this.degreeProgramMapper = degreeProgramMapper;
  }

  @Override
  public DegreeProgramDataDTO getDegreeProgramBySlug(
      String universitySlug, String degreeProgramSlug) {
    University university =
        universityRepository
            .findBySlug(universitySlug)
            .orElseThrow(() -> new UniversityNotFoundException(universitySlug));

    return degreeProgramMapper.toDataDTO(
        degreeProgramRepository
            .findByUniAndSlug(university, degreeProgramSlug)
            .orElseThrow(
                () -> new DegreeProgramNotFoundException(universitySlug, degreeProgramSlug)));
  }

  @Override
  public List<DegreeProgramDataDTO> getAllDegreePrograms(String universitySlug) {
    University university =
        universityRepository
            .findBySlug(universitySlug)
            .orElseThrow(() -> new UniversityNotFoundException(universitySlug));

    return university.getDegreePrograms().stream().map(degreeProgramMapper::toDataDTO).toList();
  }

  @Override
  public String addDegreeProgram(
      String universitySlug, DegreeProgramCreationDTO degreeProgramCreationDTO) {
    if (degreeProgramCreationDTO.name().isEmpty()) {
      throw new IllegalArgumentException();
    }

    University university =
        universityRepository
            .findBySlug(universitySlug)
            .orElseThrow(() -> new UniversityNotFoundException(universitySlug));

    Optional<DegreeProgram> deg_program =
        degreeProgramRepository.findByUniAndSlug(
            university, SlugUtil.toSlug(degreeProgramCreationDTO.name()));
    if (deg_program.isPresent()) {
      throw new DegreeProgramAlreadyExistsException(
          university.getName(), degreeProgramCreationDTO.name());
    }

    if (degreeProgramCreationDTO.duration() < 1 || degreeProgramCreationDTO.duration() > 10) {
      throw new IllegalArgumentException();
    }

    // TODO throw a more appropriate exception
    // DegreeProgramType.valueOf(degreeProgramCreationDTO.type());

    DegreeProgram degreeProgram =
        degreeProgramMapper.fromCreationDTO(degreeProgramCreationDTO, university);
    degreeProgramRepository.save(degreeProgram);
    return degreeProgram.getSlug();
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
