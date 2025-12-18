package com.miempresa.servicio.domain.mapper;

import com.miempresa.servicio.domain.dto.ExampleDto;
import com.miempresa.servicio.domain.model.ExampleEntity;

import java.util.UUID;

public class ExampleMapper {

    public ExampleEntity toEntity(ExampleDto dto) {
        return new ExampleEntity(
                UUID.randomUUID(),
                dto.getName(),
                dto.getDescription()
        );
    }
}
