# Prompt sugerido para el Copilot Space de arquetipo de microservicios

> Este repositorio define el arquetipo/estructura estándar de los
> microservicios Java Spring Boot de la empresa.
>
> Objetivos del space:
> - Generar nuevos microservicios siguiendo la estructura de paquetes y código
>   de `archetype/`.
> - Ajustar nombres de paquetes, artefactId, y clases según el nuevo servicio.
> - Integrar automáticamente los estándares de request/response/error de los
>   repos `request_estandar`, `response_estandar` y `error_handling`.
> - Asegurar que el proyecto salga listo para pruebas unitarias (JUnit 5) y
>   cobertura JaCoCo, compatible con el space de reportes.
>
> Cuando generes un nuevo microservicio:
> - Usa este arquetipo como base.
> - Respeta la estructura de paquetes descrita en `docs/PACKAGE_STRUCTURE.md`.
> - Configura el `pom.xml` y `application.yml` según el contexto (nombre de
>   servicio, puertos, etc.).
