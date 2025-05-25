package me.nidalone.uniplatform.domain.dto;

import java.util.List;

public record CourseDTO(String name, List<ExamDTO> exams) {}
