package com.project.apps.appRoutine;

import com.project.apps.application.Application;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "app_routine")
public class AppRoutine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "routine_code", nullable = false)
    private Long id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "app_code", nullable = false)
    private Application appCode;

    @Size(max = 120)
    @NotNull
    @Column(name = "name", nullable = false, length = 120)
    private String name;

    @Size(max = 50)
    @NotNull
    @Column(name = "type", nullable = false, length = 50)
    private String type;

    @Size(max = 50)
    @NotNull
    @Column(name = "sub_type", nullable = false, length = 50)
    private String subType;

    @NotNull
    @Column(name = "description", nullable = false, length = Integer.MAX_VALUE)
    private String description;

    @NotNull
    @Column(name = "last_modified", nullable = false)
    private Instant lastModified;

}