package com.project.apps.infrastructure.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
public class MissingDataException extends RuntimeException {
    private final String title;
    private final String detail;

    public MissingDataException(String title, String detail) {
        super(title);
        this.title = title;
        this.detail = detail;
    }
}

