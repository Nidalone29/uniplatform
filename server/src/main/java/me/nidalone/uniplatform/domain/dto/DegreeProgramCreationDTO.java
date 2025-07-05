package me.nidalone.uniplatform.domain.dto;

import me.nidalone.uniplatform.domain.enums.DegreeProgramType;

public record DegreeProgramCreationDTO(String name, DegreeProgramType type) {}
