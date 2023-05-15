package com.project.apps.system;

import lombok.Data;

import java.time.LocalTime;

@Data
public class ApplicationService {
    private String id;
    private String applicationId;
    private String name;
    private String type;
    private String subType;
    private String description;
    private LocalTime last_modified;
}
