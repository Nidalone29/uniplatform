package me.nidalone.uniplatform.services;

import me.nidalone.uniplatform.domain.dto.CourseCreationDTO;
import me.nidalone.uniplatform.domain.dto.CourseDataDTO;

import java.util.List;

public interface CourseService {

  CourseDataDTO getCourse(String universitySlug, String degreeProgramSlug, String courseSlug);

  List<CourseDataDTO> getAllCourses(String universitySlug, String degreeProgramSlug);

  String addNewCourse(String universitySlug, String degreeProgramSlug, CourseCreationDTO course);

  void updateCourse(
      String universitySlug,
      String degreeProgramSlug,
      String courseSlug,
      CourseDataDTO updatedCourse);

  void removeCourse(String universitySlug, String degreeProgramSlug, String courseSlug);
}
