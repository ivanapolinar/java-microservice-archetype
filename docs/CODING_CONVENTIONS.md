# Convenciones de código

- Java 17.
- Spring Boot 3.
- Nombres de clases en PascalCase.
- Nombres de métodos en camelCase.
- Controladores:
  - Prefijo `/api/v1/<recurso>`.
  - Devolver siempre el modelo estándar de respuesta (ver `api.model`).
- Servicios:
  - Métodos con nombres verbales (`createOrder`, `calculateTotal`).
- Excepciones:
  - Extender de `RuntimeException` para reglas de negocio.
  - Manejarse a través del manejador global en `exception`.

Estándares adicionales (request/response/errores) se definen en otros
repos de tu ecosistema.
