package me.nidalone.uniplatform.domain.entities;

import jakarta.persistence.*;
import me.nidalone.uniplatform.utils.SlugUtil;

import java.util.Objects;
import java.util.UUID;

@Entity
@Table(
    name = "exams",
    uniqueConstraints = {@UniqueConstraint(columnNames = {"exam_slug", "course_id"})})
public class Exam {
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  @Column(name = "exam_id", updatable = false, nullable = false)
  private UUID examID;

  @Column(name = "exam_name", nullable = false)
  private String name;

  @Column(name = "exam_slug", nullable = false)
  private String slug;

  @Column(name = "ects")
  private int ects;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "course_id")
  private Course course;

  public Exam(String name, int ects, Course course) {
    this.name = name;
    this.slug = SlugUtil.toSlug(name);
    this.ects = ects;
    this.course = course;
  }

  public Exam() {}

  public UUID getExamID() {
    return examID;
  }

  public Course getCourse() {
    return course;
  }

  public void setCourse(Course course) {
    this.course = course;
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
    Exam exam = (Exam) o;
    return ects == exam.ects
        && Objects.equals(examID, exam.examID)
        && Objects.equals(name, exam.name)
        && Objects.equals(slug, exam.slug)
        && Objects.equals(course, exam.course);
  }

  @Override
  public int hashCode() {
    return Objects.hash(examID, name, slug, ects, course);
  }
}
