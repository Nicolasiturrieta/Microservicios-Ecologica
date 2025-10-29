package gestionresiduos_auth_service.demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import gestionresiduos_auth_service.demo.dto.JwtResponse;
import gestionresiduos_auth_service.demo.dto.LoginRequest;
<<<<<<< HEAD
=======
import gestionresiduos_auth_service.demo.dto.LoginResponse;
import gestionresiduos_auth_service.demo.repository.UsuarioRepository;
>>>>>>> 47c8da7 (ajustes)
import gestionresiduos_auth_service.demo.service.AuthService;

@RestController
@RequestMapping("/auth")
public class AuthController {
    private final AuthService service;
<<<<<<< HEAD

    public AuthController(AuthService s) {
        this.service = s;
    }

    @PostMapping("/login")
    public ResponseEntity<JwtResponse> login(@RequestBody LoginRequest r) {
        return ResponseEntity.ok(new JwtResponse(service.login(r)));
    }
}
=======
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
>>>>>>> 47c8da7 (ajustes)
