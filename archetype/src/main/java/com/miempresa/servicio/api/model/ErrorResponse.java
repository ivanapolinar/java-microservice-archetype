package com.miempresa.servicio.api.model;

import java.util.List;

public class ErrorResponse {

    private String code;
    private String message;
    private List<ErrorDetail> details;
    private Meta meta;

    public ErrorResponse(String code, String message, List<ErrorDetail> details, Meta meta) {
        this.code = code;
        this.message = message;
        this.details = details;
        this.meta = meta;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public List<ErrorDetail> getDetails() {
        return details;
    }

    public Meta getMeta() {
        return meta;
    }
}
