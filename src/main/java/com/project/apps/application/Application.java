package com.project.apps.application;

import com.project.apps.appService.AppServiceInfo;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "application")
public class Application {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "app_code", nullable = false)
    private Long id;

    @Size(max = 120)
    @NotNull
    @Column(name = "name", nullable = false, length = 120)
    private String name;

    @Size(max = 50)
    @NotNull
    @Column(name = "app_group", nullable = false, length = 50)
    private String appGroup;

    @Size(max = 50)
    @NotNull
    @Column(name = "app_type", nullable = false, length = 50)
    private String appType;

    @NotNull
    @Column(name = "description", nullable = false, length = Integer.MAX_VALUE)
    private String description;

    @NotNull
    @Column(name = "app_cost", nullable = false)
    private BigDecimal appCost;

    @NotNull
    @Column(name = "last_modified", nullable = false)
    private Instant lastModified;

    @OneToMany(mappedBy = "appCode")
    private Set<AppServiceInfo> appServices = new LinkedHashSet<>();

}