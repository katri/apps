package com.project.apps.system;

import lombok.Data;

import java.time.LocalTime;

@Data
public class Application {
    private String id;
    private String name;
    private String appGroup;
    private String appType;
    private String description;
    private float appCost;
    private LocalTime last_modified;
}
