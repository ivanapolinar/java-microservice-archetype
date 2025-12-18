# Visión general del arquetipo de microservicio

Este arquetipo define cómo debe verse un microservicio Java Spring Boot
estándar en la organización.

## Principios clave

- Basado en Spring Boot (Web + Validation).
- Arquitectura por capas sencilla (controller, service, domain, repository).
- Modelo unificado de respuesta (envoltura `ApiResponse`).
- Manejo de errores consistente con los estándares de `error_handling`.
- Preparado para:
  - Pruebas unitarias con JUnit 5.
  - Cobertura con JaCoCo.
  - Integración con tus spaces de QA y estándares.

## Estructura principal

El código de ejemplo está en `archetype/src/main/java/com/miempresa/servicio`.

Se espera que al crear un nuevo proyecto:

- Cambies el paquete base a `com.miempresa.<nombreServicio>`.
- Renombres las clases de ejemplo.
- Adaptes el dominio a tu caso de uso.

Consulta `PACKAGE_STRUCTURE.md` para el detalle de cada paquete.
