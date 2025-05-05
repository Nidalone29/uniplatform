package me.nidalone.uniplatform;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "COURSE")
public class Course {
  @Id //
  private String degreeProgram;

  @ManyToMany(cascade = {CascadeType.MERGE})
  private List<Exam> exams;

  public Course(String degreeProgram, List<Exam> exams) {
    this.degreeProgram = degreeProgram;
    this.exams = exams;
  }

  public List<Exam> getExams() {
    return exams;
  }

  public void setExams(List<Exam> exams) {
    this.exams = exams;
  }

  public String getDegreeProgram() {
    return degreeProgram;
  }

  public void setDegreeProgram(String degreeProgram) {
    this.degreeProgram = degreeProgram;
  }
}
