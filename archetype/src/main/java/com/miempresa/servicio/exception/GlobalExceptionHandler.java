package com.miempresa.servicio.exception;

import com.miempresa.servicio.api.model.ErrorDetail;
import com.miempresa.servicio.api.model.ErrorResponse;
import com.miempresa.servicio.api.model.Meta;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.OffsetDateTime;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<ErrorResponse> handleBusinessException(BusinessException ex) {
        Meta meta = new Meta(OffsetDateTime.now(), "v1");
        ErrorResponse response = new ErrorResponse(
                ex.getCode(),
                ex.getMessage(),
                Collections.emptyList(),
                meta
        );
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleValidationException(MethodArgumentNotValidException ex) {
        List<ErrorDetail> details = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(this::toDetail)
                .collect(Collectors.toList());

        Meta meta = new Meta(OffsetDateTime.now(), "v1");
        ErrorResponse response = new ErrorResponse(
                "VALIDATION_ERROR",
                "Datos de entrada no válidos",
                details,
                meta
        );
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleGenericException(Exception ex) {
        Meta meta = new Meta(OffsetDateTime.now(), "v1");
        ErrorResponse response = new ErrorResponse(
                "INTERNAL_ERROR",
                "Ha ocurrido un error interno. Intenta más tarde.",
                Collections.emptyList(),
                meta
        );
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
    }

    private ErrorDetail toDetail(FieldError error) {
        return new ErrorDetail(error.getField(), error.getDefaultMessage());
    }
}
