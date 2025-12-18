package com.miempresa.servicio.service;

import com.miempresa.servicio.domain.dto.ExampleDto;
import com.miempresa.servicio.domain.mapper.ExampleMapper;
import com.miempresa.servicio.domain.model.ExampleEntity;
import com.miempresa.servicio.exception.BusinessException;
import com.miempresa.servicio.repository.ExampleRepository;

import java.util.UUID;

public class ExampleService {

    private final ExampleRepository repository;
    private final ExampleMapper mapper;

    public ExampleService(ExampleRepository repository, ExampleMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public ExampleEntity create(ExampleDto dto) {
        if ("INVALID".equalsIgnoreCase(dto.getName())) {
            throw new BusinessException("BUSINESS_INVALID_NAME", "El nombre no es permitido");
        }
        ExampleEntity entity = mapper.toEntity(dto);
        return repository.save(entity);
    }

    public ExampleEntity getById(UUID id) {
        return repository.findById(id)
                .orElseThrow(() -> new BusinessException("RESOURCE_NOT_FOUND", "Recurso no encontrado"));
    }
}
