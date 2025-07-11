package me.nidalone.uniplatform.domain.dto;

import me.nidalone.uniplatform.domain.enums.DegreeProgramType;

public record DegreeProgramDataDTO(
    String name, String slug, DegreeProgramType type, int duration) {}
