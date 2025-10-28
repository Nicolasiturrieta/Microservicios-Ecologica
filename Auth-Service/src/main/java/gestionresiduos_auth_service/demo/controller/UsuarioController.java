package gestionresiduos_auth_service.demo.controller;

import java.util.List;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import gestionresiduos_auth_service.demo.model.Usuario;
import gestionresiduos_auth_service.demo.repository.RoleRepository;
import gestionresiduos_auth_service.demo.repository.UsuarioRepository;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
    private final UsuarioRepository repo;
    private final RoleRepository roles;
    private final BCryptPasswordEncoder enc = new BCryptPasswordEncoder();

    public UsuarioController(UsuarioRepository r, RoleRepository rr) {
        this.repo = r;
        this.roles = rr;
    }

    @PostMapping
    public Usuario crear(@RequestBody Usuario u) {
        u.setPasswordHash(enc.encode(u.getPasswordHash()));
        return repo.save(u);
    }

    @GetMapping
    public List<Usuario> listar() {
        return repo.findAll();
    }
}