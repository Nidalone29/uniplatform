package me.nidalone.uniplatform.domain.dto;

import me.nidalone.uniplatform.domain.enums.CourseAttendance;
import me.nidalone.uniplatform.domain.enums.CourseTypeOfExam;

public record CourseDataDTO(
    String name,
    String slug,
    int ects,
    CourseTypeOfExam type_of_exam,
    CourseAttendance attendance) {}
