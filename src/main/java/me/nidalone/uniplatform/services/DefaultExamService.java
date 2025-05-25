package me.nidalone.uniplatform.services;

import me.nidalone.uniplatform.domain.entities.Course;
import me.nidalone.uniplatform.domain.entities.Exam;
import me.nidalone.uniplatform.domain.entities.University;
import me.nidalone.uniplatform.exceptions.CourseNotFoundException;
import me.nidalone.uniplatform.exceptions.ExamNotFoundException;
import me.nidalone.uniplatform.exceptions.UniNotFoundException;
import me.nidalone.uniplatform.repositories.CourseRepository;
import me.nidalone.uniplatform.repositories.ExamRepository;
import me.nidalone.uniplatform.repositories.UniversityRepository;
import org.springframework.stereotype.Service;

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
  public void addNewExam(String universitySlug, String courseSlug, String examName) {
    University university =
        universityRepository
            .findBySlug(universitySlug)
            .orElseThrow(() -> new UniNotFoundException(universitySlug));
    Course course =
        courseRepository
            .findByUniAndSlug(university, courseSlug)
            .orElseThrow(() -> new CourseNotFoundException(courseSlug));

    // TODO check if exam already exists
    course.addExam(new Exam(examName, 0, course));
    courseRepository.save(course);
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
