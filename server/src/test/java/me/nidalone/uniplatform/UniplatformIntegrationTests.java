package me.nidalone.uniplatform;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

import me.nidalone.uniplatform.controllers.UniversityController;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.MySQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import org.springframework.boot.test.context.SpringBootTest;
import org.testcontainers.utility.DockerImageName;

@Testcontainers
@SpringBootTest
class UniplatformIntegrationTests {

  @Autowired private UniversityController controller;

  @Container
  static MySQLContainer<?> mysqldb = new MySQLContainer<>(DockerImageName.parse("mysql:8.4.5"));

  @BeforeAll
  static void beforeAll() {
    mysqldb.start();
  }

  @AfterAll
  static void afterAll() {
    mysqldb.stop();
  }

  @DynamicPropertySource
  static void configureProperties(DynamicPropertyRegistry registry) {
    registry.add("spring.datasource.url", () -> mysqldb.getJdbcUrl());
    registry.add("spring.datasource.username", () -> mysqldb.getUsername());
    registry.add("spring.datasource.password", () -> mysqldb.getPassword());
  }

  @Test
  void contextLoads() throws Exception {
    assertTrue(mysqldb.isRunning());
    assertThat(controller).isNotNull();
  }

  @Test
  void getUniversity() {}

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
