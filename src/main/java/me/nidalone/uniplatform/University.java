package me.nidalone.uniplatform;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "UNIVERSITY")
public class University {
  @Id //
  private String name;

  @ManyToMany(cascade = {CascadeType.MERGE})
  private List<Course> courses;

  public University(String name, List<Course> courses) {
    this.name = name;
    this.courses = courses;
  }

  public University(String name) {
    this.name = name;
    this.courses = new ArrayList<Course>();
  }

  public University() {
    this.name = "test";
    this.courses = new ArrayList<Course>();
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public List<Course> getCourses() {
    return courses;
  }

  public void setCourses(List<Course> courses) {
    this.courses = courses;
  }

  public Course findCourse(String courseName) {
    for (Course x : this.courses) {
      if (x.getDegreeProgram().equals(courseName)) {
        return x;
      }
    }
    return null;
  }

  public void deleteCourse(Course course) {
    this.courses.remove(course);
  }
}
