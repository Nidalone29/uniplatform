package me.nidalone.uniplatform.services;

import me.nidalone.uniplatform.domain.entities.Course;

public interface CourseService {

  Course getCourse(String universitySlug, String courseSlug);

  void addCourse(String universitySlug, String courseName);

  void removeCourse(String universitySlug, String courseSlug);
}
