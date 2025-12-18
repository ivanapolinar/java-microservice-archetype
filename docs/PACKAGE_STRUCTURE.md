# Estructura de paquetes del microservicio

Paquete base de ejemplo:
`com.miempresa.servicio`

## Paquetes

- `config`:
  - Configuraciones de Spring (por ejemplo, OpenAPI, CORS, seguridad básica).
- `controller`:
  - Controladores REST (`@RestController`).
- `service`:
  - Lógica de negocio principal.
- `domain.model`:
  - Entidades de dominio (no necesariamente entidades JPA, pueden ser modelos puros).
- `domain.dto`:
  - DTOs de entrada/salida.
- `domain.mapper`:
  - Mappers entre entidades, DTOs, modelos de dominio.
- `repository`:
  - Interfaces de acceso a datos (ej. Spring Data JPA).
- `exception`:
  - Excepciones de negocio.
  - Manejador global de excepciones (`@ControllerAdvice`).
- `api.model`:
  - Modelos comunes de la API (envolturas de respuesta, errores, meta).

En `src/test/java` se refleja la misma estructura, con clases de test
para `service` y `controller`.
