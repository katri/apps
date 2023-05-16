package com.project.apps.application;

import lombok.Data;

import java.io.Serializable;

@Data
public class ApplicationResponseView implements Serializable {
    private final long id;
    private final String name;
    private final String appGroup;
    private final String appType;
    private final String description;
    private final int appCost;
}
