package me.nidalone.uniplatform.services;

import com.neovisionaries.i18n.CountryCode;
import me.nidalone.uniplatform.domain.dto.UniversityCreationDTO;
import me.nidalone.uniplatform.domain.dto.UniversityDataDTO;
import me.nidalone.uniplatform.domain.entities.University;
import me.nidalone.uniplatform.exceptions.UniversityAlreadyExistsException;
import me.nidalone.uniplatform.exceptions.UniversityNotFoundException;
import me.nidalone.uniplatform.mappers.UniversityMapper;
import me.nidalone.uniplatform.repositories.UniversityRepository;
import me.nidalone.uniplatform.utils.SlugUtil;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DefaultUniversityService implements UniversityService {
  private final UniversityRepository universityRepository;
  private final UniversityMapper universityMapper;

  public DefaultUniversityService(
      UniversityRepository universityRepository, UniversityMapper universityMapper) {
    this.universityRepository = universityRepository;
    this.universityMapper = universityMapper;
  }

  @Override
  public List<UniversityDataDTO> getAllUniversities() {
    return universityRepository.findAll().stream().map(universityMapper::toDataDTO).toList();
  }

  @Override
  public UniversityDataDTO getUniversityBySlug(String universitySlug) {
    return universityMapper.toDataDTO(
        universityRepository
            .findBySlug(universitySlug)
            .orElseThrow(() -> new UniversityNotFoundException(universitySlug)));
  }

  @Override
  public String addNewUniversity(UniversityCreationDTO universityCreationDTO) {
    final String uni_name = universityCreationDTO.name();
    if (uni_name == null || uni_name.isEmpty()) {
      throw new IllegalArgumentException("Invalid name");
    }

    Optional.ofNullable(universityRepository.findBySlug(SlugUtil.toSlug(uni_name)))
        .orElseThrow(() -> new UniversityAlreadyExistsException(uni_name));

    // getByAlpha2Code throws "Name is null" when you don't provide a country_code
    CountryCode cc =
        Optional.ofNullable(CountryCode.getByAlpha2Code(universityCreationDTO.country_code()))
            .orElseThrow(() -> new IllegalArgumentException("Country not found"));
    if (cc.getAssignment() != CountryCode.Assignment.OFFICIALLY_ASSIGNED) {
      throw new IllegalArgumentException("Country not officially assigned");
    }

    final String uni_acronym = universityCreationDTO.acronym();
    if (uni_acronym != null
        && !uni_acronym.isEmpty()
        && (uni_acronym.length() < 3 || uni_acronym.length() > 15)) {
      throw new IllegalArgumentException();
    }

    University university = universityMapper.fromCreationDTO(universityCreationDTO);
    universityRepository.save(university);
    return university.getSlug();
  }

  @Override
  public void deleteUniversityBySlug(String universitySlug) {
    University uni =
        universityRepository
            .findBySlug(universitySlug)
            .orElseThrow(() -> new UniversityNotFoundException(universitySlug));

    universityRepository.delete(uni);
  }
}
