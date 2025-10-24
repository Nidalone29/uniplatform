package me.nidalone.uniplatform.controllers;

import java.util.List;

import me.nidalone.uniplatform.domain.dto.DegreeProgramCreationDTO;
import me.nidalone.uniplatform.domain.dto.DegreeProgramDataDTO;
import me.nidalone.uniplatform.services.DegreeProgramService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping(path = "/api/universities/{universitySlug}/degree-programs")
public class DegreeProgramController {
  private final DegreeProgramService degreeProgramService;

  public DegreeProgramController(DegreeProgramService degreeProgramService) {
    this.degreeProgramService = degreeProgramService;
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
    return ResponseEntity.ok().body(degreeProgramService.getAllDegreePrograms(universitySlug));
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
        degreeProgramService.getDegreeProgramBySlug(universitySlug, degreeProgramSlug));
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
    String slug = degreeProgramService.addDegreeProgram(universitySlug, degreeProgramCreationDTO);
    return ResponseEntity.created(
            ServletUriComponentsBuilder.fromCurrentRequestUri()
                .path("/{slug}")
                .buildAndExpand(slug)
                .toUri())
        .build();
  }

  /**
   * @param universitySlug
   * @param degreeProgramSlug
   * @param degreeProgramDataDTO
   * @return
   */
  @PutMapping("/{degreeProgramSlug}/update")
  public ResponseEntity<String> updateDegreeProgram(
      @PathVariable String universitySlug,
      @PathVariable String degreeProgramSlug,
      @ModelAttribute DegreeProgramDataDTO degreeProgramDataDTO) {
    degreeProgramService.updateDegreeProgram(
        universitySlug, degreeProgramSlug, degreeProgramDataDTO);
    return ResponseEntity.ok("Course updated successfully!");
  }

  @DeleteMapping("/{degreeProgramSlug}")
  public ResponseEntity<String> deleteDegreeProgramSlug(
      @PathVariable String universitySlug, @PathVariable String degreeProgramSlug) {
    degreeProgramService.removeDegreeProgram(universitySlug, degreeProgramSlug);
    return ResponseEntity.ok("Degree Program deleted!");
  }
}
