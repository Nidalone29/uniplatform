package me.nidalone.uniplatform.domain.dto;

import java.util.List;

public record CourseDTO(String name, String slug, List<ExamDTO> exams) {}
