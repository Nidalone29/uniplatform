package me.nidalone.uniplatform.repositories;

import me.nidalone.uniplatform.domain.entities.University;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface UniversityRepository extends JpaRepository<University, UUID> {
  Optional<University> findBySlug(String universitySlug);
}
