package me.nidalone.uniplatform.services;

import me.nidalone.uniplatform.domain.dto.CourseCreationDTO;
import me.nidalone.uniplatform.domain.dto.CourseDataDTO;
import me.nidalone.uniplatform.domain.entities.Course;
import me.nidalone.uniplatform.domain.entities.DegreeProgram;
import me.nidalone.uniplatform.domain.entities.University;
import me.nidalone.uniplatform.domain.enums.CourseAttendance;
import me.nidalone.uniplatform.domain.enums.CourseTypeOfExam;
import me.nidalone.uniplatform.exceptions.DegreeProgramNotFoundException;
import me.nidalone.uniplatform.exceptions.CourseAlreadyExistsException;
import me.nidalone.uniplatform.exceptions.CourseNotFoundException;
import me.nidalone.uniplatform.exceptions.UniversityNotFoundException;
import me.nidalone.uniplatform.mappers.CourseMapper;
import me.nidalone.uniplatform.repositories.DegreeProgramRepository;
import me.nidalone.uniplatform.repositories.CourseRepository;
import me.nidalone.uniplatform.repositories.UniversityRepository;
import me.nidalone.uniplatform.utils.SlugUtil;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DefaultCourseService implements CourseService {
  private final CourseRepository courseRepository;
  private final DegreeProgramRepository degreeProgramRepository;
  private final UniversityRepository universityRepository;
  private final CourseMapper courseMapper;

  public DefaultCourseService(
      CourseRepository courseRepository,
      DegreeProgramRepository degreeProgramRepository,
      UniversityRepository universityRepository,
      CourseMapper courseMapper) {
    this.courseRepository = courseRepository;
    this.degreeProgramRepository = degreeProgramRepository;
    this.universityRepository = universityRepository;
    this.courseMapper = courseMapper;
  }

  @Override
  public CourseDataDTO getCourse(
      String universitySlug, String degreeProgramSlug, String courseSlug) {
    University university =
        universityRepository
            .findBySlug(universitySlug)
            .orElseThrow(() -> new UniversityNotFoundException(universitySlug));
    DegreeProgram degreeProgram =
        degreeProgramRepository
            .findByUniAndSlug(university, degreeProgramSlug)
            .orElseThrow(
                () -> new DegreeProgramNotFoundException(universitySlug, degreeProgramSlug));

    return courseMapper.toDataDTO(
        courseRepository
            .findByDegreeProgramAndSlug(degreeProgram, courseSlug)
            .orElseThrow(
                () -> new CourseNotFoundException(universitySlug, degreeProgramSlug, courseSlug)));
  }

  @Override
  public List<CourseDataDTO> getAllCourses(String universitySlug, String degreeProgramSlug) {
    University university =
        universityRepository
            .findBySlug(universitySlug)
            .orElseThrow(() -> new UniversityNotFoundException(universitySlug));
    DegreeProgram degreeProgram =
        degreeProgramRepository
            .findByUniAndSlug(university, degreeProgramSlug)
            .orElseThrow(
                () -> new DegreeProgramNotFoundException(universitySlug, degreeProgramSlug));

    return degreeProgram.getCourses().stream().map(courseMapper::toDataDTO).toList();
  }

  @Override
  public String addNewCourse(
      String universitySlug, String degreeProgramSlug, CourseCreationDTO courseCreationDTO) {
    University university =
        universityRepository
            .findBySlug(universitySlug)
            .orElseThrow(() -> new UniversityNotFoundException(universitySlug));
    DegreeProgram degreeProgram =
        degreeProgramRepository
            .findByUniAndSlug(university, degreeProgramSlug)
            .orElseThrow(
                () -> new DegreeProgramNotFoundException(universitySlug, degreeProgramSlug));

    if (courseCreationDTO.name().isEmpty()) {
      throw new IllegalArgumentException();
    }

    Optional<Course> c =
        courseRepository.findByDegreeProgramAndSlug(
            degreeProgram, SlugUtil.toSlug(courseCreationDTO.name()));
    if (c.isPresent()) {
      throw new CourseAlreadyExistsException(
          university.getName(), degreeProgram.getName(), courseCreationDTO.name());
    }

    if (courseCreationDTO.ects() < 1 || courseCreationDTO.ects() > 30) {
      throw new IllegalArgumentException();
    }

    // TODO throw a more appropriate exception
    // CourseTypeOfExam.valueOf(courseCreationDTO.type_of_exam());
    // CourseAttendance.valueOf(courseCreationDTO.attendance());

    Course course = courseMapper.fromCreationDTO(courseCreationDTO, degreeProgram);
    courseRepository.save(course);
    return course.getSlug();
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
