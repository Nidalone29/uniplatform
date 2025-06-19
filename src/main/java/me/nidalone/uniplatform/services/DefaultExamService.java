package me.nidalone.uniplatform.services;

import me.nidalone.uniplatform.domain.entities.Course;
import me.nidalone.uniplatform.domain.entities.Exam;
import me.nidalone.uniplatform.domain.entities.University;
import me.nidalone.uniplatform.exceptions.CourseNotFoundException;
import me.nidalone.uniplatform.exceptions.ExamAlreadyExistsException;
import me.nidalone.uniplatform.exceptions.ExamNotFoundException;
import me.nidalone.uniplatform.exceptions.UniNotFoundException;
import me.nidalone.uniplatform.repositories.CourseRepository;
import me.nidalone.uniplatform.repositories.ExamRepository;
import me.nidalone.uniplatform.repositories.UniversityRepository;
import me.nidalone.uniplatform.utils.SlugUtil;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DefaultExamService implements ExamService {
  private final ExamRepository examRepository;
  private final CourseRepository courseRepository;
  private final UniversityRepository universityRepository;

  public DefaultExamService(
      ExamRepository examRepository,
      CourseRepository courseRepository,
      UniversityRepository universityRepository) {
    this.examRepository = examRepository;
    this.courseRepository = courseRepository;
    this.universityRepository = universityRepository;
  }

  @Override
  public Exam getExam(String universitySlug, String courseSlug, String examSlug) {
    University university =
        universityRepository
            .findBySlug(universitySlug)
            .orElseThrow(() -> new UniNotFoundException(universitySlug));
    Course course =
        courseRepository
            .findByUniAndSlug(university, courseSlug)
            .orElseThrow(() -> new CourseNotFoundException(courseSlug));

    return examRepository
        .findByCourseAndSlug(course, examSlug)
        .orElseThrow(() -> new ExamNotFoundException(courseSlug, examSlug));
  }

  @Override
  public List<Exam> getAllExams(String universitySlug, String courseSlug) {
    University university =
        universityRepository
            .findBySlug(universitySlug)
            .orElseThrow(() -> new UniNotFoundException(universitySlug));
    Course course =
        courseRepository
            .findByUniAndSlug(university, courseSlug)
            .orElseThrow(() -> new CourseNotFoundException(courseSlug));
    return course.getExams();
  }

  @Override
  public void addNewExam(String universitySlug, String courseSlug, Exam exam) {
    if (exam.getName().isEmpty()) {
      throw new IllegalArgumentException();
    }

    if (exam.getSlug().isEmpty()) {
      // It means that the exam was created with no parameters somehow
      throw new RuntimeException();
    }

    if (exam.getEcts() < 1 || exam.getEcts() > 30) {
      throw new IllegalArgumentException();
    }

    University university =
        universityRepository
            .findBySlug(universitySlug)
            .orElseThrow(() -> new UniNotFoundException(universitySlug));
    Course course =
        courseRepository
            .findByUniAndSlug(university, courseSlug)
            .orElseThrow(() -> new CourseNotFoundException(courseSlug));

    Optional<Exam> e = examRepository.findByCourseAndSlug(course, exam.getSlug());
    if (e.isPresent()) {
      throw new ExamAlreadyExistsException(university.getName(), course.getName(), exam.getName());
    }

    examRepository.save(exam);
  }

  @Override
  public void updateExamECTS(String universitySlug, String courseSlug, String examSlug, int ects) {
    University university =
        universityRepository
            .findBySlug(universitySlug)
            .orElseThrow(() -> new UniNotFoundException(universitySlug));
    Course course =
        courseRepository
            .findByUniAndSlug(university, courseSlug)
            .orElseThrow(() -> new CourseNotFoundException(courseSlug));
    Exam exam =
        examRepository
            .findByCourseAndSlug(course, examSlug)
            .orElseThrow(() -> new ExamNotFoundException(courseSlug, examSlug));

    exam.setEcts(ects);
    examRepository.save(exam);
  }

  @Override
  public void removeExam(String universitySlug, String courseSlug, String examSlug) {
    University university =
        universityRepository
            .findBySlug(universitySlug)
            .orElseThrow(() -> new UniNotFoundException(universitySlug));
    Course course =
        courseRepository
            .findByUniAndSlug(university, courseSlug)
            .orElseThrow(() -> new CourseNotFoundException(courseSlug));
    Exam exam =
        examRepository
            .findByCourseAndSlug(course, examSlug)
            .orElseThrow(() -> new ExamNotFoundException(courseSlug, examSlug));

    examRepository.delete(exam);
  }
}
