package com.project.apps.appRoutine;

import lombok.Data;

import java.io.Serializable;
import java.time.Instant;

/**
 * A DTO for the {@link AppRoutine} entity
 */
@Data
public class AppRoutineResponseView implements Serializable {
    private final Long id;
    private final String name;
    private final String type;
    private final String subType;
    private final String description;
    private final Instant lastModified;
}