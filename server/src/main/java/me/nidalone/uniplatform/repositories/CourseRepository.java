package me.nidalone.uniplatform.repositories;

import me.nidalone.uniplatform.domain.entities.DegreeProgram;
import me.nidalone.uniplatform.domain.entities.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface CourseRepository extends JpaRepository<Course, UUID> {
  Optional<Course> findByDegreeProgramAndSlug(DegreeProgram degreeProgramID, String courseSlug);

  Optional<Course> findBySlug(String courseSlug);
}
