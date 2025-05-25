package me.nidalone.uniplatform.domain.dto;

import java.util.List;

public record UniversityDTO(String name, List<CourseDTO> courses) {}
