package me.nidalone.uniplatform.services;

import me.nidalone.uniplatform.domain.entities.Course;

import java.util.List;

public interface CourseService {

  Course getCourse(String universitySlug, String degreeProgramSlug, String courseSlug);

  List<Course> getAllCourses(String universitySlug, String degreeProgramSlug);

  void addNewCourse(String universitySlug, String degreeProgramSlug, Course course);

  void updateCourseECTS(
      String universitySlug, String degreeProgramSlug, String courseSlug, int ects);

  void removeCourse(String universitySlug, String degreeProgramSlug, String courseSlug);
}
