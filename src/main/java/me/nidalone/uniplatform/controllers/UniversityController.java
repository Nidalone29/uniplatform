package me.nidalone.uniplatform.controllers;

import java.util.List;

import me.nidalone.uniplatform.domain.dto.UniversityDTO;
import me.nidalone.uniplatform.mappers.UniversityMapper;
import me.nidalone.uniplatform.services.UniversityService;
import me.nidalone.uniplatform.utils.SlugUtil;
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
  public ResponseEntity<UniversityDTO> getUniversity(@PathVariable String universitySlug) {
    return ResponseEntity.ok()
        .body(universityMapper.toDTO(universityService.getUniversityBySlug(universitySlug)));
  }

  /**
   * Get all the universities
   *
   * @return All universities present in the database
   */
  @GetMapping(path = "/")
  public ResponseEntity<List<UniversityDTO>> getAllUniversities() {
    return ResponseEntity.ok()
        .body(
            universityService.getAllUniversities().stream().map(universityMapper::toDTO).toList());
  }

  /**
   * Add a new university to the database by name
   *
   * @param name University name to add
   * @return Success message or throw UniAlreadyExistsException
   */
  @PostMapping(path = "/")
  public ResponseEntity<String> addNewUniversity(@RequestParam String name) {
    universityService.addNewUniversity(name);
    String slug = SlugUtil.toSlug(name);
    return ResponseEntity.created(
            ServletUriComponentsBuilder.fromCurrentRequest()
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
