package me.nidalone.uniplatform.domain.entities;

import jakarta.persistence.*;
import me.nidalone.uniplatform.domain.enums.DegreeProgramType;
import me.nidalone.uniplatform.utils.SlugUtil;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

@Entity
@Table(
    name = "degree_programs",
    uniqueConstraints = {@UniqueConstraint(columnNames = {"degree_program_slug", "university_id"})})
public class DegreeProgram {
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  @Column(name = "degree_program_id", updatable = false, nullable = false)
  private UUID degreeProgramID;

  @Column(name = "degree_program_name", nullable = false)
  private String name;

  @Column(name = "degree_program_slug", nullable = false)
  private String slug;

  @Column(name = "degree_program_type", nullable = false)
  @Enumerated(EnumType.STRING)
  private DegreeProgramType type;

  @OneToMany(
      mappedBy = "degreeProgram",
      cascade = {CascadeType.ALL})
  private List<Course> courses;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "university_id")
  private University uni;

  public DegreeProgram(String name, DegreeProgramType type, List<Course> courses, University uni) {
    this.name = name;
    this.slug = SlugUtil.toSlug(name);
    this.type = type;
    this.courses = courses;
    this.uni = uni;
  }

  public DegreeProgram(String name, DegreeProgramType type, University uni) {
    this.name = name;
    this.slug = SlugUtil.toSlug(name);
    this.type = type;
    this.uni = uni;
  }

  public DegreeProgram() {}

  public UUID getDegreeProgramID() {
    return degreeProgramID;
  }

  public List<Course> getCourses() {
    return courses;
  }

  public void setCourses(List<Course> courses) {
    this.courses = courses;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getSlug() {
    return slug;
  }

  public DegreeProgramType getType() {
    return type;
  }

  public void setType(DegreeProgramType type) {
    this.type = type;
  }

  public University getUni() {
    return uni;
  }

  public void setUni(University uni) {
    this.uni = uni;
  }

  @Override
  public boolean equals(Object o) {
    if (o == null || getClass() != o.getClass()) return false;
    DegreeProgram degreeProgram = (DegreeProgram) o;
    return Objects.equals(degreeProgramID, degreeProgram.degreeProgramID)
        && Objects.equals(name, degreeProgram.name)
        && Objects.equals(slug, degreeProgram.slug)
        && Objects.equals(courses, degreeProgram.courses)
        && Objects.equals(uni, degreeProgram.uni);
  }

  @Override
  public int hashCode() {
    return Objects.hash(degreeProgramID, name, slug, courses, uni);
  }

  public Optional<Course> findCourse(String course) {
    for (Course e : this.courses) {
      if (e.getName().equals(course)) {
        return Optional.of(e);
      }
    }
    return Optional.empty();
  }

  public void addCourse(Course course) {
    this.courses.add(course);
  }
}
