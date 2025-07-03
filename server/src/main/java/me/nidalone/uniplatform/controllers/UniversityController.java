package me.nidalone.uniplatform.controllers;

import java.util.List;

import me.nidalone.uniplatform.domain.dto.UniversityCreationDTO;
import me.nidalone.uniplatform.domain.dto.UniversityDataDTO;
import me.nidalone.uniplatform.mappers.UniversityMapper;
import me.nidalone.uniplatform.services.UniversityService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping(path = "/api/universities")
public class UniversityController {
  private final UniversityService universityService;
  private final UniversityMapper universityMapper;

  public UniversityController(
      UniversityService universityService, UniversityMapper universityMapper) {
    this.universityService = universityService;
    this.universityMapper = universityMapper;
  }

  /**
   * Show a particular university
   *
   * @param universitySlug The university Slug as a string
   * @return University object if found, otherwise throw UniversityNotFoundException
   */
  @GetMapping(path = "/{universitySlug}")
  public ResponseEntity<UniversityDataDTO> getUniversity(@PathVariable String universitySlug) {
    return ResponseEntity.ok()
        .body(universityMapper.toDataDTO(universityService.getUniversityBySlug(universitySlug)));
  }

  /**
   * Get all the universities
   *
   * @return All universities present in the database
   */
  @GetMapping(path = "/")
  public ResponseEntity<List<UniversityDataDTO>> getAllUniversities() {
    return ResponseEntity.ok()
        .body(
            universityService.getAllUniversities().stream()
                .map(universityMapper::toDataDTO)
                .toList());
  }

  /**
   * Add a new university to the database
   *
   * @param universityCreationDTO to add
   * @return Success message or throw UniversityAlreadyExistsException
   */
  @PostMapping(path = "/")
  public ResponseEntity<String> addNewUniversity(
      @ModelAttribute UniversityCreationDTO universityCreationDTO) {
    String slug = universityService.addNewUniversity(universityCreationDTO);
    return ResponseEntity.created(
            ServletUriComponentsBuilder.fromCurrentRequestUri()
                .path("/{slug}")
                .buildAndExpand(slug)
                .toUri())
        .build();
  }

  /**
   * University to delete
   *
   * @param universitySlug University to delete
   * @return
   */
  @DeleteMapping("/{universitySlug}")
  public ResponseEntity<String> deleteUniversity(@PathVariable String universitySlug) {
    universityService.deleteUniversityBySlug(universitySlug);
    return ResponseEntity.ok("Uni deleted");
  }
}
