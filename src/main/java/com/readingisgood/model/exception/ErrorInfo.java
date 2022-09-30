package com.readingisgood.model.exception;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;

import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
public class ErrorInfo {
    private final String code;
    private final String message;
    private final Map<String, String> additionalInfo;

    public ErrorInfo(final String code, final String message, final Map<String, String> additionalInfo) {
        this.code = code;
        this.message = message;
        this.additionalInfo = additionalInfo;
    }

    public ErrorInfo(final String code, final String message) {
        this(code, message, null);
    }
}
