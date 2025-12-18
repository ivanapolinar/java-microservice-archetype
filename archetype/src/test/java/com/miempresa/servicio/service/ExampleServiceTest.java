package com.miempresa.servicio.service;

import com.miempresa.servicio.domain.dto.ExampleDto;
import com.miempresa.servicio.domain.mapper.ExampleMapper;
import com.miempresa.servicio.domain.model.ExampleEntity;
import com.miempresa.servicio.exception.BusinessException;
import com.miempresa.servicio.repository.ExampleRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ExampleServiceTest {

    @Mock
    private ExampleRepository repository;

    @Mock
    private ExampleMapper mapper;

    @InjectMocks
    private ExampleService exampleService;

    @Test
    void shouldCreateEntity_whenDtoIsValid() {
        // Arrange
        ExampleDto dto = new ExampleDto();
        dto.setName("Valid Name");
        dto.setDescription("Desc");

        ExampleEntity mapped = new ExampleEntity(UUID.randomUUID(), dto.getName(), dto.getDescription());

        when(mapper.toEntity(dto)).thenReturn(mapped);
        when(repository.save(any(ExampleEntity.class))).thenReturn(mapped);

        // Act
        ExampleEntity result = exampleService.create(dto);

        // Assert
        assertThat(result.getName()).isEqualTo("Valid Name");
    }

    @Test
    void shouldThrowBusinessException_whenNameIsInvalid() {
        // Arrange
        ExampleDto dto = new ExampleDto();
        dto.setName("INVALID");

        // Act & Assert
        assertThatThrownBy(() -> exampleService.create(dto))
                .isInstanceOf(BusinessException.class)
                .hasMessage("El nombre no es permitido");
    }

    @Test
    void shouldReturnEntity_whenIdExists() {
        // Arrange
        UUID id = UUID.randomUUID();
        ExampleEntity entity = new ExampleEntity(id, "Name", "Desc");

        when(repository.findById(id)).thenReturn(Optional.of(entity));

        // Act
        ExampleEntity result = exampleService.getById(id);

        // Assert
        assertThat(result.getId()).isEqualTo(id);
    }

    @Test
    void shouldThrowBusinessException_whenIdNotFound() {
        // Arrange
        UUID id = UUID.randomUUID();
        when(repository.findById(id)).thenReturn(Optional.empty());

        // Act & Assert
        assertThatThrownBy(() -> exampleService.getById(id))
                .isInstanceOf(BusinessException.class)
                .hasMessage("Recurso no encontrado");
    }
}
