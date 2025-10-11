package gestionresiduos_auth_service.demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import gestionresiduos_auth_service.demo.dto.JwtResponse;
import gestionresiduos_auth_service.demo.dto.LoginRequest;
import gestionresiduos_auth_service.demo.service.AuthService;

@RestController
@RequestMapping("/auth")
public class AuthController {
    private final AuthService service;

    public AuthController(AuthService s) {
        this.service = s;
    }

    @PostMapping("/login")
    public ResponseEntity<JwtResponse> login(@RequestBody LoginRequest r) {
        return ResponseEntity.ok(new JwtResponse(service.login(r)));
    }
}