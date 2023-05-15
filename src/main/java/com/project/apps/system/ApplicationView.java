package com.project.apps.system;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.Set;

/**
 * A DTO for the {@link Application} entity
 */
@Data
public class ApplicationView implements Serializable {
    private final Long id;
    @Size(max = 120)
    @NotNull
    private final String name;
    @Size(max = 50)
    @NotNull
    private final String appGroup;
    @Size(max = 50)
    @NotNull
    private final String appType;
    @NotNull
    private final String description;
    @NotNull
    private final BigDecimal appCost;
    @NotNull
    private final Instant lastModified;
    private final Set<AppServiceInfoView> appServices;
}