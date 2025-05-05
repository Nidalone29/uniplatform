package me.nidalone.uniplatform;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path = "/api")
public class MainController {
  @Autowired //
  private UniRepository uniRepository;

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
