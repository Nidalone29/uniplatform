package me.nidalone.uniplatform.services;

import me.nidalone.uniplatform.domain.entities.Course;
import me.nidalone.uniplatform.domain.entities.University;
import me.nidalone.uniplatform.exceptions.CourseNotFoundException;
import me.nidalone.uniplatform.exceptions.UniNotFoundException;
import me.nidalone.uniplatform.repositories.CourseRepository;
import me.nidalone.uniplatform.repositories.UniversityRepository;
import org.springframework.stereotype.Service;

@Service
public class DefaultCourseService implements CourseService {
  private final CourseRepository courseRepository;
  private final UniversityRepository universityRepository;

  public DefaultCourseService(
      CourseRepository courseRepository, UniversityRepository universityRepository) {
    this.courseRepository = courseRepository;
    this.universityRepository = universityRepository;
  }

  @Override
  public Course getCourse(String universitySlug, String courseSlug) {
    University university =
        universityRepository
            .findBySlug(universitySlug)
            .orElseThrow(() -> new UniNotFoundException(universitySlug));

    return courseRepository
        .findByUniAndSlug(university, courseSlug)
        .orElseThrow(() -> new CourseNotFoundException(courseSlug));
  }

  @Override
  public void addCourse(String universitySlug, String courseName) {
    University university =
        universityRepository
            .findBySlug(universitySlug)
            .orElseThrow(() -> new UniNotFoundException(universitySlug));

    // TODO check if course already exists
    university.addCourse(new Course(courseName, university));
    universityRepository.save(university);
  }

  @Override
  public void removeCourse(String universitySlug, String courseSlug) {
    University university =
        universityRepository
            .findBySlug(universitySlug)
            .orElseThrow(() -> new UniNotFoundException(universitySlug));

    courseRepository.delete(
        courseRepository
            .findByUniAndSlug(university, courseSlug)
            .orElseThrow(() -> new CourseNotFoundException(courseSlug)));
  }
}
