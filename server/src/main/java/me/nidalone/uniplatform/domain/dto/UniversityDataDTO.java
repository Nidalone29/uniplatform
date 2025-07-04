package me.nidalone.uniplatform.domain.dto;

public record UniversityDataDTO(
    String name, String slug, String country_code, String acronym, int number_of_programs) {}
