package me.nidalone.uniplatform.domain.entities;

import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

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

  @OneToMany(
      mappedBy = "uni",
      cascade = {CascadeType.ALL})
  private List<DegreeProgram> degreePrograms;

  public University(String name, List<DegreeProgram> degreePrograms) {
    this.name = name;
    this.slug = SlugUtil.toSlug(name);
    this.degreePrograms = degreePrograms;
  }

  public University(String name) {
    this.name = name;
    this.slug = SlugUtil.toSlug(name);
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

  @Override
  public boolean equals(Object o) {
    if (o == null || getClass() != o.getClass()) return false;
    University that = (University) o;
    return Objects.equals(universityID, that.universityID)
        && Objects.equals(name, that.name)
        && Objects.equals(slug, that.slug)
        && Objects.equals(degreePrograms, that.degreePrograms);
  }

  @Override
  public int hashCode() {
    return Objects.hash(universityID, name, slug, degreePrograms);
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
