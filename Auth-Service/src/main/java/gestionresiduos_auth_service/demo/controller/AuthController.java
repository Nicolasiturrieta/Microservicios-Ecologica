package gestionresiduos_auth_service.demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import gestionresiduos_auth_service.demo.dto.LoginRequest;
import gestionresiduos_auth_service.demo.dto.LoginResponse;
import gestionresiduos_auth_service.demo.repository.UsuarioRepository;
import gestionresiduos_auth_service.demo.service.AuthService;

@RestController
@RequestMapping("/auth")
public class AuthController {
    private final AuthService service;
    private final UsuarioRepository users;

    public AuthController(AuthService s, UsuarioRepository u) {
        this.service = s;
        this.users = u;
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest r) {
        String token = service.login(r);
        var u = users.findByUsername(r.rut()).orElseThrow();
        var rol = u.getRoles().stream().findFirst().map(x -> x.getNombre()).orElse("");
        return ResponseEntity.ok(new LoginResponse(token, "Bearer", u.getId(), u.getNombre(), u.getUsername(), rol));
    }
}
