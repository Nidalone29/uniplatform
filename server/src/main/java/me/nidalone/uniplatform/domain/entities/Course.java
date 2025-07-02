package me.nidalone.uniplatform.domain.entities;

import jakarta.persistence.*;
import me.nidalone.uniplatform.utils.SlugUtil;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

@Entity
@Table(
    name = "courses",
    uniqueConstraints = {@UniqueConstraint(columnNames = {"course_slug", "university_id"})})
public class Course {
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  @Column(name = "course_id", updatable = false, nullable = false)
  private UUID courseID;

  @Column(name = "course_name", nullable = false)
  private String name;

  @Column(name = "course_slug", nullable = false)
  private String slug;

  @OneToMany(
      mappedBy = "course",
      cascade = {CascadeType.ALL})
  private List<Exam> exams;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "university_id")
  private University uni;

  public Course(String name, List<Exam> exams, University uni) {
    this.name = name;
    this.slug = SlugUtil.toSlug(name);
    this.exams = exams;
    this.uni = uni;
  }

  public Course(String name, University uni) {
    this.name = name;
    this.slug = SlugUtil.toSlug(name);
    this.uni = uni;
  }

  public Course() {}

  public UUID getCourseID() {
    return courseID;
  }

  public List<Exam> getExams() {
    return exams;
  }

  public void setExams(List<Exam> exams) {
    this.exams = exams;
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

  public University getUni() {
    return uni;
  }

  public void setUni(University uni) {
    this.uni = uni;
  }

  @Override
  public boolean equals(Object o) {
    if (o == null || getClass() != o.getClass()) return false;
    Course course = (Course) o;
    return Objects.equals(courseID, course.courseID)
        && Objects.equals(name, course.name)
        && Objects.equals(slug, course.slug)
        && Objects.equals(exams, course.exams)
        && Objects.equals(uni, course.uni);
  }

  @Override
  public int hashCode() {
    return Objects.hash(courseID, name, slug, exams, uni);
  }

  public Optional<Exam> findExam(String exam) {
    for (Exam e : this.exams) {
      if (e.getName().equals(exam)) {
        return Optional.of(e);
      }
    }
    return Optional.empty();
  }

  public void addExam(Exam exam) {
    this.exams.add(exam);
  }
}
