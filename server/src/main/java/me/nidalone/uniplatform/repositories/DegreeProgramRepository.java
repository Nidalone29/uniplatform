package me.nidalone.uniplatform.repositories;

import me.nidalone.uniplatform.domain.entities.DegreeProgram;
import me.nidalone.uniplatform.domain.entities.University;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface DegreeProgramRepository extends JpaRepository<DegreeProgram, UUID> {
  Optional<DegreeProgram> findByUniAndSlug(University uni, String degreeProgramSlug);

  Optional<DegreeProgram> findBySlug(String degreeProgramSlug);
}
