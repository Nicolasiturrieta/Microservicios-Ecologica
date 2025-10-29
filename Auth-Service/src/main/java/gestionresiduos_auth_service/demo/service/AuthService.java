package gestionresiduos_auth_service.demo.service;

import gestionresiduos_auth_service.demo.dto.LoginRequest;
import gestionresiduos_auth_service.demo.model.Role;
import gestionresiduos_auth_service.demo.model.Usuario;
import gestionresiduos_auth_service.demo.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final JwtService jwtService;
    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;

    public String login(LoginRequest req) {
        // En este contexto, 'rut' es el username
        Usuario usuario = usuarioRepository.findByUsername(req.rut())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Credenciales inválidas"));

        if (usuario.getActivo() != null && !usuario.getActivo()) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Usuario inactivo");
        }

        if (!passwordEncoder.matches(req.password(), usuario.getPasswordHash())) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Credenciales inválidas");
        }

        List<String> roles = usuario.getRoles().stream().map(Role::getNombre).toList();
        return jwtService.generate(usuario.getUsername(), roles);
    }
}

