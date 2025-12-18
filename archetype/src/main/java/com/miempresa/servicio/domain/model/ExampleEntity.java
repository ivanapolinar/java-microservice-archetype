package com.miempresa.servicio.domain.model;

import java.util.UUID;

public class ExampleEntity {

    private UUID id;
    private String name;
    private String description;

    public ExampleEntity(UUID id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}
