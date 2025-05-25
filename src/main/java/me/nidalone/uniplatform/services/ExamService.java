package me.nidalone.uniplatform.services;

import me.nidalone.uniplatform.domain.entities.Exam;

public interface ExamService {

  Exam getExam(String universitySlug, String courseSlug, String examSlug);

  void addNewExam(String universitySlug, String courseSlug, String examName);

  void updateExamECTS(String universitySlug, String courseSlug, String examSlug, int ects);

  void removeExam(String universitySlug, String courseSlug, String examSlug);
}
