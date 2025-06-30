package me.nidalone.uniplatform.services;

import me.nidalone.uniplatform.domain.entities.Course;
import me.nidalone.uniplatform.domain.entities.University;
import me.nidalone.uniplatform.exceptions.CourseAlreadyExistsException;
import me.nidalone.uniplatform.exceptions.CourseNotFoundException;
import me.nidalone.uniplatform.exceptions.UniAlreadyExistsException;
import me.nidalone.uniplatform.exceptions.UniNotFoundException;
import me.nidalone.uniplatform.repositories.CourseRepository;
import me.nidalone.uniplatform.repositories.UniversityRepository;
import me.nidalone.uniplatform.utils.SlugUtil;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
  public Course getCourseBySlug(String universitySlug, String courseSlug) {
    University university =
        universityRepository
            .findBySlug(universitySlug)
            .orElseThrow(() -> new UniNotFoundException(universitySlug));

    return courseRepository
        .findByUniAndSlug(university, courseSlug)
        .orElseThrow(() -> new CourseNotFoundException(courseSlug));
  }

  @Override
  public List<Course> getAllCourses(String universitySlug) {
    University university =
        universityRepository
            .findBySlug(universitySlug)
            .orElseThrow(() -> new UniNotFoundException(universitySlug));
    return university.getCourses();
  }

  @Override
  public void addCourse(String universitySlug, Course course) {
    if (course.getName().isEmpty()) {
      throw new IllegalArgumentException();
    }

    if (course.getSlug().isEmpty()) {
      // It means that the course was created with no parameters somehow
      throw new RuntimeException();
    }

    University university =
        universityRepository
            .findBySlug(universitySlug)
            .orElseThrow(() -> new UniNotFoundException(universitySlug));

    Optional<Course> c = courseRepository.findByUniAndSlug(university, course.getSlug());
    if (c.isPresent()) {
      throw new CourseAlreadyExistsException(university.getName(), course.getName());
    }

    courseRepository.save(course);
    // university.addCourse(new Course(courseName, university));
    // universityRepository.save(university);
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
