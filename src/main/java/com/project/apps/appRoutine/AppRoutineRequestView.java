package com.project.apps.appRoutine;

import lombok.Data;

import java.io.Serializable;

/**
 * A DTO for the {@link AppRoutine} entity
 */
@Data
public class AppRoutineRequestView implements Serializable {
    private final String name;
    private final Long appCode;
    private final String type;
    private final String subType;
    private final String description;
}