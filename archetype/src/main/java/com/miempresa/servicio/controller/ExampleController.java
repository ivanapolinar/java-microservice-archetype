package com.miempresa.servicio.controller;

import com.miempresa.servicio.api.model.ApiResponse;
import com.miempresa.servicio.api.model.Meta;
import com.miempresa.servicio.domain.dto.ExampleDto;
import com.miempresa.servicio.domain.model.ExampleEntity;
import com.miempresa.servicio.service.ExampleService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.OffsetDateTime;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/examples")
public class ExampleController {

    private final ExampleService exampleService;

    public ExampleController(ExampleService exampleService) {
        this.exampleService = exampleService;
    }

    @PostMapping
    public ResponseEntity<ApiResponse<ExampleEntity>> create(@Valid @RequestBody ExampleDto dto) {
        ExampleEntity entity = exampleService.create(dto);
        Meta meta = new Meta(OffsetDateTime.now(), "v1");
        ApiResponse<ExampleEntity> response = new ApiResponse<>(entity, meta);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<ExampleEntity>> getById(@PathVariable UUID id) {
        ExampleEntity entity = exampleService.getById(id);
        Meta meta = new Meta(OffsetDateTime.now(), "v1");
        ApiResponse<ExampleEntity> response = new ApiResponse<>(entity, meta);
        return ResponseEntity.ok(response);
    }
}
