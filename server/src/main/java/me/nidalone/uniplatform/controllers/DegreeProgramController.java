package me.nidalone.uniplatform.controllers;

import java.util.List;

import me.nidalone.uniplatform.domain.dto.DegreeProgramCreationDTO;
import me.nidalone.uniplatform.domain.dto.DegreeProgramDataDTO;
import me.nidalone.uniplatform.domain.entities.DegreeProgram;
import me.nidalone.uniplatform.domain.entities.University;
import me.nidalone.uniplatform.mappers.DegreeProgramMapper;
import me.nidalone.uniplatform.services.DegreeProgramService;
import me.nidalone.uniplatform.services.UniversityService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping(path = "/api/universities/{universitySlug}/degree-programs")
public class DegreeProgramController {
  private final DegreeProgramService degreeProgramService;
  private final UniversityService universityService;

  private final DegreeProgramMapper degreeProgramMapper;

  public DegreeProgramController(
      DegreeProgramService degreeProgramService,
      UniversityService universityService,
      DegreeProgramMapper degreeProgramMapper) {
    this.degreeProgramService = degreeProgramService;
    this.universityService = universityService;
    this.degreeProgramMapper = degreeProgramMapper;
  }

  /**
   * Get all degree programs of a university
   *
   * @param universitySlug
   * @return
   */
  @GetMapping(path = "/")
  public ResponseEntity<List<DegreeProgramDataDTO>> getAllDegreePrograms(
      @PathVariable String universitySlug) {
    return ResponseEntity.ok()
        .body(
            degreeProgramService.getAllDegreePrograms(universitySlug).stream()
                .map(degreeProgramMapper::toDataDTO)
                .toList());
  }

  /**
   * Get a degree program
   *
   * @param universitySlug
   * @param degreeProgramSlug
   * @return
   */
  @GetMapping(path = "/{degreeProgramSlug}")
  public ResponseEntity<DegreeProgramDataDTO> getDegreeProgram(
      @PathVariable String universitySlug, @PathVariable String degreeProgramSlug) {
    return ResponseEntity.ok(
        degreeProgramMapper.toDataDTO(
            degreeProgramService.getDegreeProgramBySlug(universitySlug, degreeProgramSlug)));
  }

  /**
   * @param universitySlug
   * @param degreeProgramCreationDTO
   * @return
   */
  @PostMapping(path = "/")
  public ResponseEntity<String> addNewDegreeProgram(
      @PathVariable String universitySlug,
      @ModelAttribute DegreeProgramCreationDTO degreeProgramCreationDTO) {
    University university = universityService.getUniversityBySlug(universitySlug);
    DegreeProgram degreeProgram =
        degreeProgramMapper.fromCreationDTO(degreeProgramCreationDTO, university);
    degreeProgramService.addDegreeProgram(universitySlug, degreeProgram);
    // at this point if there are not any throws the entity has been created
    String slug = degreeProgram.getSlug();
    return ResponseEntity.created(
            ServletUriComponentsBuilder.fromCurrentRequestUri()
                .path("/{slug}")
                .buildAndExpand(slug)
                .toUri())
        .build();
  }

  @DeleteMapping("/{degreeProgramSlug}")
  public ResponseEntity<String> deleteDegreeProgramSlug(
      @PathVariable String universitySlug, @PathVariable String degreeProgramSlug) {
    degreeProgramService.removeDegreeProgram(universitySlug, degreeProgramSlug);
    return ResponseEntity.ok("Degree Program deleted!");
  }
}
