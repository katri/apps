package com.project.apps.appService;

import lombok.Data;

import java.io.Serializable;
import java.time.Instant;

/**
 * A DTO for the {@link AppServiceInfo} entity
 */
@Data
public class AppServiceInfoView implements Serializable {
    private final String name;
    private final String type;
    private final String subType;
    private final String description;
    private final Instant lastModified;
}