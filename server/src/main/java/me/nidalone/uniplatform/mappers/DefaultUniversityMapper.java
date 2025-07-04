package me.nidalone.uniplatform.mappers;

import com.neovisionaries.i18n.CountryCode;
import me.nidalone.uniplatform.domain.dto.UniversityCreationDTO;
import me.nidalone.uniplatform.domain.dto.UniversityDataDTO;
import me.nidalone.uniplatform.domain.entities.University;
import org.springframework.stereotype.Component;

@Component
public class DefaultUniversityMapper implements UniversityMapper {

  @Override
  public University fromCreationDTO(UniversityCreationDTO universityCreationDTO) {
    return new University(
        universityCreationDTO.name(),
        CountryCode.getByAlpha2Code(universityCreationDTO.country_code()),
        universityCreationDTO.acronym());
  }

  @Override
  public UniversityDataDTO toDataDTO(University university) {
    return new UniversityDataDTO(
        university.getName(),
        university.getSlug(),
        university.getCountryAsISOAlpha2(),
        university.getAcronym(),
        university.getDegreePrograms().size());
  }
}
