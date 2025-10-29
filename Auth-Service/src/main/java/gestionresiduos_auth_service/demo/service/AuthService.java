package gestionresiduos_auth_service.demo.service;

import java.util.stream.Collectors;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import gestionresiduos_auth_service.demo.dto.LoginRequest;
import gestionresiduos_auth_service.demo.repository.UsuarioRepository;

@Service
public class AuthService {
    private final UsuarioRepository users;
    private final JwtService jwt;
    private final BCryptPasswordEncoder enc = new BCryptPasswordEncoder();

    public AuthService(UsuarioRepository u, JwtService j) {
        this.users = u;
        this.jwt = j;
    }

    public String login(LoginRequest r) {
<<<<<<< HEAD
        var u = users.findByUsername(r.username()).orElseThrow();
=======
        var u = users.findByUsername(r.rut()).orElseThrow();
>>>>>>> 47c8da7 (ajustes)
        if (!enc.matches(r.password(), u.getPasswordHash()))
            throw new RuntimeException("Credenciales inválidas");
        var roles = u.getRoles().stream().map(x -> x.getNombre()).collect(Collectors.toList());
        return jwt.generate(u.getUsername(), roles);
    }
<<<<<<< HEAD
}
=======
}
>>>>>>> 47c8da7 (ajustes)
