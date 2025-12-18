package com.miempresa.servicio.api.model;

import java.time.OffsetDateTime;

public class Meta {

    private OffsetDateTime timestamp;
    private String version;

    public Meta(OffsetDateTime timestamp, String version) {
        this.timestamp = timestamp;
        this.version = version;
    }

    public OffsetDateTime getTimestamp() {
        return timestamp;
    }

    public String getVersion() {
        return version;
    }
}
