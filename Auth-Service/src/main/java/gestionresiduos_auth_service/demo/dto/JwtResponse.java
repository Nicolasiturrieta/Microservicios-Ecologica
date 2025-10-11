package gestionresiduos_auth_service.demo.dto;

public record JwtResponse(String accessToken, String tokenType) {
    public JwtResponse(String t) {
        this(t, "Bearer");
    }
}
