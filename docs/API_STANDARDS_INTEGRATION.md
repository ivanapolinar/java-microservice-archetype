# Integración con los estándares de API

Este arquetipo está diseñado para trabajar de la mano con:

- `request_estandar`: convención de requests (headers, body, params).
- `response_estandar`: formato de respuestas exitosas.
- `error_handling`: formato y manejo de errores.

En el código de ejemplo verás:

- `ApiResponse<T>` y `Meta`: inspirados en `response_estandar`.
- `ErrorResponse` y `ErrorDetail`: inspirados en `error_handling`.
- `GlobalExceptionHandler`: punto central para mapear excepciones a respuestas.

Cuando uses este arquetipo en un nuevo microservicio, puedes pedirle a
Copilot que ajuste los detalles para alinearlos exactamente con esos
repos de estándares.
