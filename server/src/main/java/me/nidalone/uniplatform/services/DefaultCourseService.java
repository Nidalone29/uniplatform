package me.nidalone.uniplatform.services;

import me.nidalone.uniplatform.domain.entities.Course;
import me.nidalone.uniplatform.domain.entities.DegreeProgram;
import me.nidalone.uniplatform.domain.entities.University;
import me.nidalone.uniplatform.exceptions.DegreeProgramNotFoundException;
import me.nidalone.uniplatform.exceptions.CourseAlreadyExistsException;
import me.nidalone.uniplatform.exceptions.CourseNotFoundException;
import me.nidalone.uniplatform.exceptions.UniversityNotFoundException;
import me.nidalone.uniplatform.repositories.DegreeProgramRepository;
import me.nidalone.uniplatform.repositories.CourseRepository;
import me.nidalone.uniplatform.repositories.UniversityRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DefaultCourseService implements CourseService {
  private final CourseRepository courseRepository;
  private final DegreeProgramRepository degreeProgramRepository;
  private final UniversityRepository universityRepository;

  public DefaultCourseService(
      CourseRepository courseRepository,
      DegreeProgramRepository degreeProgramRepository,
      UniversityRepository universityRepository) {
    this.courseRepository = courseRepository;
    this.degreeProgramRepository = degreeProgramRepository;
    this.universityRepository = universityRepository;
  }

  @Override
  public Course getCourse(String universitySlug, String degreeProgramSlug, String courseSlug) {
    University university =
        universityRepository
            .findBySlug(universitySlug)
            .orElseThrow(() -> new UniversityNotFoundException(universitySlug));
    DegreeProgram degreeProgram =
        degreeProgramRepository
            .findByUniAndSlug(university, degreeProgramSlug)
            .orElseThrow(
                () -> new DegreeProgramNotFoundException(universitySlug, degreeProgramSlug));

    return courseRepository
        .findByDegreeProgramAndSlug(degreeProgram, courseSlug)
        .orElseThrow(
            () -> new CourseNotFoundException(universitySlug, degreeProgramSlug, courseSlug));
  }

  @Override
  public List<Course> getAllCourses(String universitySlug, String degreeProgramSlug) {
    University university =
        universityRepository
            .findBySlug(universitySlug)
            .orElseThrow(() -> new UniversityNotFoundException(universitySlug));
    DegreeProgram degreeProgram =
        degreeProgramRepository
            .findByUniAndSlug(university, degreeProgramSlug)
            .orElseThrow(
                () -> new DegreeProgramNotFoundException(universitySlug, degreeProgramSlug));
    return degreeProgram.getCourses();
  }

  @Override
  public void addNewCourse(String universitySlug, String degreeProgramSlug, Course course) {
    if (course.getName().isEmpty()) {
      throw new IllegalArgumentException();
    }

    if (course.getSlug().isEmpty()) {
      // It means that the course was created with no parameters somehow
      throw new RuntimeException();
    }

    if (course.getEcts() < 1 || course.getEcts() > 30) {
      throw new IllegalArgumentException();
    }

    University university =
        universityRepository
            .findBySlug(universitySlug)
            .orElseThrow(() -> new UniversityNotFoundException(universitySlug));
    DegreeProgram degreeProgram =
        degreeProgramRepository
            .findByUniAndSlug(university, degreeProgramSlug)
            .orElseThrow(
                () -> new DegreeProgramNotFoundException(universitySlug, degreeProgramSlug));

    Optional<Course> c =
        courseRepository.findByDegreeProgramAndSlug(degreeProgram, course.getSlug());
    if (c.isPresent()) {
      throw new CourseAlreadyExistsException(
          university.getName(), degreeProgram.getName(), course.getName());
    }

    courseRepository.save(course);
  }

  @Override
  public void updateCourseECTS(
      String universitySlug, String degreeProgramSlug, String courseSlug, int ects) {
    University university =
        universityRepository
            .findBySlug(universitySlug)
            .orElseThrow(() -> new UniversityNotFoundException(universitySlug));
    DegreeProgram degreeProgram =
        degreeProgramRepository
            .findByUniAndSlug(university, degreeProgramSlug)
            .orElseThrow(
                () -> new DegreeProgramNotFoundException(universitySlug, degreeProgramSlug));
    Course course =
        courseRepository
            .findByDegreeProgramAndSlug(degreeProgram, courseSlug)
            .orElseThrow(
                () -> new CourseNotFoundException(universitySlug, degreeProgramSlug, courseSlug));

    course.setEcts(ects);
    courseRepository.save(course);
  }

  @Override
  public void removeCourse(String universitySlug, String degreeProgramSlug, String courseSlug) {
    University university =
        universityRepository
            .findBySlug(universitySlug)
            .orElseThrow(() -> new UniversityNotFoundException(universitySlug));
    DegreeProgram degreeProgram =
        degreeProgramRepository
            .findByUniAndSlug(university, degreeProgramSlug)
            .orElseThrow(
                () -> new DegreeProgramNotFoundException(universitySlug, degreeProgramSlug));
    Course course =
        courseRepository
            .findByDegreeProgramAndSlug(degreeProgram, courseSlug)
            .orElseThrow(
                () -> new CourseNotFoundException(universitySlug, degreeProgramSlug, courseSlug));

    courseRepository.delete(course);
  }
}
