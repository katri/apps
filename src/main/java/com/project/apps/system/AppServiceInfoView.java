package com.project.apps.system;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.io.Serializable;
import java.time.Instant;

/**
 * A DTO for the {@link AppServiceInfo} entity
 */
@Data
public class AppServiceInfoView implements Serializable {
    private final Long id;
    @Size(max = 120)
    @NotNull
    private final String name;
    @Size(max = 50)
    @NotNull
    private final String type;
    @Size(max = 50)
    @NotNull
    private final String subType;
    @NotNull
    private final String description;
    @NotNull
    private final Instant lastModified;
}