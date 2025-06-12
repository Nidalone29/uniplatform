package me.nidalone.uniplatform.services;

import me.nidalone.uniplatform.domain.entities.Course;
import me.nidalone.uniplatform.domain.entities.Exam;

import java.util.List;

public interface ExamService {

  Exam getExam(String universitySlug, String courseSlug, String examSlug);

  List<Exam> getAllExams(String universitySlug, String courseSlug);

  void addNewExam(String universitySlug, String courseSlug, String examName);

  void updateExamECTS(String universitySlug, String courseSlug, String examSlug, int ects);

  void removeExam(String universitySlug, String courseSlug, String examSlug);
}
