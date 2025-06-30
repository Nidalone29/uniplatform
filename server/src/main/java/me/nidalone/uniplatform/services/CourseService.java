package me.nidalone.uniplatform.services;

import me.nidalone.uniplatform.domain.entities.Course;

import java.util.List;

public interface CourseService {

  Course getCourseBySlug(String universitySlug, String courseSlug);

  List<Course> getAllCourses(String universitySlug);

  void addCourse(String universitySlug, Course course);

  void removeCourse(String universitySlug, String courseSlug);
}
