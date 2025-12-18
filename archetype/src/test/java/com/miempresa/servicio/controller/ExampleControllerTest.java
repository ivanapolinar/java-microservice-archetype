package com.miempresa.servicio.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.miempresa.servicio.api.model.ApiResponse;
import com.miempresa.servicio.domain.dto.ExampleDto;
import com.miempresa.servicio.domain.model.ExampleEntity;
import com.miempresa.servicio.service.ExampleService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.UUID;

import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ExampleController.class)
class ExampleControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private ExampleService exampleService;

    @Test
    void shouldCreateExample_whenRequestIsValid() throws Exception {
        // Arrange
        ExampleDto dto = new ExampleDto();
        dto.setName("Valid Name");
        dto.setDescription("Desc");

        ExampleEntity entity = new ExampleEntity(UUID.randomUUID(), dto.getName(), dto.getDescription());

        Mockito.when(exampleService.create(any(ExampleDto.class)))
                .thenReturn(entity);

        // Act & Assert
        mockMvc.perform(post("/api/v1/examples")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(dto)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.data.id").value(entity.getId().toString()))
                .andExpect(jsonPath("$.data.name").value("Valid Name"))
                .andExpect(jsonPath("$.meta.version").value("v1"));
    }

    @Test
    void shouldReturnExample_whenIdExists() throws Exception {
        // Arrange
        UUID id = UUID.randomUUID();
        ExampleEntity entity = new ExampleEntity(id, "Name", "Desc");

        Mockito.when(exampleService.getById(id)).thenReturn(entity);

        // Act & Assert
        mockMvc.perform(get("/api/v1/examples/" + id))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.data.id").value(id.toString()))
                .andExpect(jsonPath("$.data.name").value("Name"));
    }
}
