package com.project.apps.application;

import com.project.apps.appRoutine.AppRoutineResponseView;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class ApplicationWithRoutinesView implements Serializable {
    private final long appId;
    private final String appName;
    private final String appGroup;
    private final String appType;
    private final String description;
    private final int appCost;
    private List<AppRoutineResponseView> routines;
    }