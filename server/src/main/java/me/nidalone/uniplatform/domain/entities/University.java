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
  private List<Course> courses;

  public University(String name, List<Course> courses) {
    this.name = name;
    this.slug = SlugUtil.toSlug(name);
    this.courses = courses;
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

  public List<Course> getCourses() {
    return courses;
  }

  public void setCourses(List<Course> courses) {
    this.courses = courses;
  }

  @Override
  public boolean equals(Object o) {
    if (o == null || getClass() != o.getClass()) return false;
    University that = (University) o;
    return Objects.equals(universityID, that.universityID)
        && Objects.equals(name, that.name)
        && Objects.equals(slug, that.slug)
        && Objects.equals(courses, that.courses);
  }

  @Override
  public int hashCode() {
    return Objects.hash(universityID, name, slug, courses);
  }

  public Optional<Course> findCourse(String courseName) {
    for (Course x : this.courses) {
      if (x.getName().equals(courseName)) {
        return Optional.of(x);
      }
    }
    return Optional.empty();
  }

  public void deleteCourse(Course course) {
    this.courses.remove(course);
  }

  public void addCourse(Course course) {
    courses.add(course);
  }
}
