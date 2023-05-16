package com.project.apps.validation;

import com.project.apps.application.ApplicationRequestView;
import com.project.apps.infrastructure.exception.MissingDataException;

public class ValidationService {
    public static final String MISSING_DATA = "Andmed on puudu";
    public static void validateRequest(ApplicationRequestView request) {
        if (request.getName() == null ||
                request.getDescription() == null ||
                request.getAppType() == null ||
                request.getAppGroup() == null) {
            throw new MissingDataException(MISSING_DATA, request.toString());
        }
    }
}