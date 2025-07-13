package me.nidalone.uniplatform.domain.entities;

import com.neovisionaries.i18n.CountryCode;
import jakarta.persistence.*;

import java.util.*;

import me.nidalone.uniplatform.utils.SlugUtil;

@Entity
@Table(name = "universities")
public class University {
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  @Column(name = "university_id", updatable = false, nullable = false)
  private UUID universityID;

  @Column(name = "university_name", nullable = false)
  private String name;

  @Column(name = "university_slug", nullable = false, unique = true)
  private String slug;

  // This is an ISO 3166 code
  @Column(name = "university_country", nullable = false)
  @Enumerated(EnumType.STRING)
  private CountryCode country;

  @Column(name = "university_acronym")
  private String acronym;

  @OneToMany(
      mappedBy = "uni",
      cascade = {CascadeType.ALL})
  private List<DegreeProgram> degreePrograms;

  public University(
      String name, CountryCode country, String acronym, List<DegreeProgram> degreePrograms) {
    this.name = name;
    this.slug = SlugUtil.toSlug(name);
    this.country = country;
    this.acronym = acronym;
    this.degreePrograms = degreePrograms;
  }

  public University(String name, CountryCode country, List<DegreeProgram> degreePrograms) {
    this.name = name;
    this.slug = SlugUtil.toSlug(name);
    this.country = country;
    this.degreePrograms = degreePrograms;
  }

  public University(String name, CountryCode country, String acronym) {
    this.name = name;
    this.slug = SlugUtil.toSlug(name);
    this.country = country;
    this.acronym = acronym;
  }

  public University(String name, CountryCode country) {
    this.name = name;
    this.slug = SlugUtil.toSlug(name);
    this.country = country;
  }

  public University() {}

  public UUID getUniversityID() {
    return universityID;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
    slug = SlugUtil.toSlug(name);
  }

  public String getSlug() {
    return slug;
  }

  public List<DegreeProgram> getDegreePrograms() {
    return degreePrograms;
  }

  public void setDegreePrograms(List<DegreeProgram> degreePrograms) {
    this.degreePrograms = degreePrograms;
  }

  public String getCountryAsISOAlpha2() {
    return country.getAlpha2();
  }

  public CountryCode getCountry() {
    return country;
  }

  public void setCountry(CountryCode country) {
    this.country = country;
  }

  public String getAcronym() {
    return acronym;
  }

  public void setAcronym(String acronym) {
    this.acronym = acronym;
  }

  @Override
  public boolean equals(Object o) {
    if (o == null || getClass() != o.getClass()) return false;
    University that = (University) o;
    return Objects.equals(universityID, that.universityID)
        && Objects.equals(name, that.name)
        && Objects.equals(slug, that.slug)
        && country == that.country
        && Objects.equals(acronym, that.acronym)
        && Objects.equals(degreePrograms, that.degreePrograms);
  }

  @Override
  public int hashCode() {
    return Objects.hash(universityID, name, slug, country, acronym, degreePrograms);
  }

  public Optional<DegreeProgram> findDegreeProgram(String degreeProgram) {
    for (DegreeProgram x : this.degreePrograms) {
      if (x.getName().equals(degreeProgram)) {
        return Optional.of(x);
      }
    }
    return Optional.empty();
  }

  public void deleteDegreeProgram(DegreeProgram degreeProgram) {
    this.degreePrograms.remove(degreeProgram);
  }

  public void addDegreeProgram(DegreeProgram degreeProgram) {
    this.degreePrograms.add(degreeProgram);
  }
}
