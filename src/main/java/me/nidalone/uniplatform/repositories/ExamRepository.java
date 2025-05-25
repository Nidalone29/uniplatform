package me.nidalone.uniplatform.repositories;

import me.nidalone.uniplatform.domain.entities.Course;
import me.nidalone.uniplatform.domain.entities.Exam;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface ExamRepository extends JpaRepository<Exam, UUID> {
  Optional<Exam> findByCourseAndSlug(Course courseID, String examSlug);

  Optional<Exam> findBySlug(String examSlug);
}
