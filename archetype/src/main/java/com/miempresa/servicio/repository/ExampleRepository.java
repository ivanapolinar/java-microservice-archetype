package com.miempresa.servicio.repository;

import com.miempresa.servicio.domain.model.ExampleEntity;

import java.util.Optional;
import java.util.UUID;

public interface ExampleRepository {

    ExampleEntity save(ExampleEntity entity);

    Optional<ExampleEntity> findById(UUID id);
}
