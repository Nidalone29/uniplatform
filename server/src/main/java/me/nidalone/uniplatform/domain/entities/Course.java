package me.nidalone.uniplatform.domain.entities;

import jakarta.persistence.*;
import me.nidalone.uniplatform.utils.SlugUtil;

import java.util.Objects;
import java.util.UUID;

@Entity
@Table(
    name = "courses",
    uniqueConstraints = {@UniqueConstraint(columnNames = {"course_slug", "degree_program_id"})})
public class Course {
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  @Column(name = "course_id", updatable = false, nullable = false)
  private UUID courseID;

  @Column(name = "course_name", nullable = false)
  private String name;

  @Column(name = "course_slug", nullable = false)
  private String slug;

  @Column(name = "ects")
  private int ects;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "degree_program_id")
  private DegreeProgram degreeProgram;

  public Course(String name, int ects, DegreeProgram degreeProgram) {
    this.name = name;
    this.slug = SlugUtil.toSlug(name);
    this.ects = ects;
    this.degreeProgram = degreeProgram;
  }

  public Course() {}

  public UUID getCourseID() {
    return courseID;
  }

  public DegreeProgram getDegreeProgram() {
    return degreeProgram;
  }

  public void setDegreeProgram(DegreeProgram degreeProgram) {
    this.degreeProgram = degreeProgram;
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

  public int getEcts() {
    return ects;
  }

  public void setEcts(int ects) {
    this.ects = ects;
  }

  @Override
  public boolean equals(Object o) {
    if (o == null || getClass() != o.getClass()) return false;
    Course course = (Course) o;
    return ects == course.ects
        && Objects.equals(courseID, course.courseID)
        && Objects.equals(name, course.name)
        && Objects.equals(slug, course.slug)
        && Objects.equals(degreeProgram, course.degreeProgram);
  }

  @Override
  public int hashCode() {
    return Objects.hash(courseID, name, slug, ects, degreeProgram);
  }
}
