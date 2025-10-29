package gestionresiduos_auth_service.demo.dto;

public record LoginResponse(
    String accessToken,
    String tokenType,
    Long id,
    String nombre,
    String rut,
    String rol
) {}

