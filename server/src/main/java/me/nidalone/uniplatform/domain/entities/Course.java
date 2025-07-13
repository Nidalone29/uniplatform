package me.nidalone.uniplatform.domain.entities;

import jakarta.persistence.*;
import me.nidalone.uniplatform.domain.enums.CourseAttendance;
import me.nidalone.uniplatform.domain.enums.CourseTypeOfExam;
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

  @Column(name = "course_ects", nullable = false)
  private int ects;

  @Column(name = "course_type_of_exam", nullable = false)
  @Enumerated(EnumType.STRING)
  private CourseTypeOfExam typeOfExam;

  @Column(name = "course_attendance", nullable = false)
  @Enumerated(EnumType.STRING)
  private CourseAttendance attendance;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "degree_program_id")
  private DegreeProgram degreeProgram;

  public Course(
      String name,
      int ects,
      CourseTypeOfExam typeOfExam,
      CourseAttendance attendance,
      DegreeProgram degreeProgram) {
    this.name = name;
    this.slug = SlugUtil.toSlug(name);
    this.ects = ects;
    this.typeOfExam = typeOfExam;
    this.attendance = attendance;
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

  public CourseTypeOfExam getTypeOfExam() {
    return typeOfExam;
  }

  public void setTypeOfExam(CourseTypeOfExam typeOfExam) {
    this.typeOfExam = typeOfExam;
  }

  public CourseAttendance getAttendance() {
    return attendance;
  }

  public void setAttendance(CourseAttendance attendance) {
    this.attendance = attendance;
  }

  @Override
  public boolean equals(Object o) {
    if (o == null || getClass() != o.getClass()) return false;
    Course course = (Course) o;
    return ects == course.ects
        && Objects.equals(courseID, course.courseID)
        && Objects.equals(name, course.name)
        && Objects.equals(slug, course.slug)
        && typeOfExam == course.typeOfExam
        && attendance == course.attendance
        && Objects.equals(degreeProgram, course.degreeProgram);
  }

  @Override
  public int hashCode() {
    return Objects.hash(courseID, name, slug, ects, typeOfExam, attendance, degreeProgram);
  }
}
