package me.nidalone.uniplatform;

import me.nidalone.uniplatform.controllers.UniversityController;
import me.nidalone.uniplatform.repositories.UniversityRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@WebMvcTest(UniversityController.class)
class UniversityControllerUnitTest {

  @Autowired private MockMvc mockMvc;
  @MockitoBean private UniversityRepository universityRepository;

  @Test
  void getUniversity() throws Exception {
    mockMvc
        .perform(MockMvcRequestBuilders.get("/api/").contentType(MediaType.APPLICATION_JSON))
        .andExpect(MockMvcResultMatchers.status().is2xxSuccessful());
  }

  @Test
  void getAllUniversities() {}

  @Test
  void getCourseExams() {}

  @Test
  void getExam() {}

  @Test
  void addNewUniversity() {}

  @Test
  void addNewCourse() {}

  @Test
  void addNewExam() {}

  @Test
  void updateCFU() {}

  @Test
  void deleteUniversity() {}

  @Test
  void deleteCourse() {}

  @Test
  void deleteExam() {}
}
