package me.nidalone.uniplatform;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path = "/api")
public class MainController {
  @Autowired //
  private UniRepository uniRepository;

  /**
   * GET - show a particular university
   *
   * @param UniversityID The university ID as a string
   * @return University object if found, otherwise throw UniversityNotFoundException
   */
  @GetMapping("/{UniversityID}")
  public @ResponseBody University getUniversity(@PathVariable String UniversityID) {
    return uniRepository
        .findById(UniversityID)
        .orElseThrow(() -> new UniNotFoundException(UniversityID));
  }

  @PostMapping(path = "/add")
  public @ResponseBody String addNewUser(@RequestParam String name) {
    University u = new University(name);
    uniRepository.save(u);
    return "Saved";
  }

  @GetMapping(path = "/")
  public @ResponseBody Iterable<University> getAllUniversities() {
    return uniRepository.findAll();
  }
}
