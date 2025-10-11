package gestionresiduos_auth_service.demo;

import java.util.Set;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import gestionresiduos_auth_service.demo.model.Role;
import gestionresiduos_auth_service.demo.model.Usuario;
import gestionresiduos_auth_service.demo.repository.RoleRepository;
import gestionresiduos_auth_service.demo.repository.UsuarioRepository;

@SpringBootApplication
public class AuthApplication {
	public static void main(String[] args) {
		SpringApplication.run(AuthApplication.class, args);
	}

	@Bean
	CommandLineRunner seed(RoleRepository rr, UsuarioRepository ur) {
		return args -> {
			var enc = new BCryptPasswordEncoder();
			var admin = rr.findByNombre("ADMIN").orElseGet(() -> rr.save(new Role(null, "ADMIN")));
			var chofer = rr.findByNombre("CHOFER").orElseGet(() -> rr.save(new Role(null, "CHOFER")));
			if (!ur.existsByUsername("admin"))
				ur.save(new Usuario(null, "admin", enc.encode("admin123"), "Admin", "", "admin@demo.cl", true,
						Set.of(admin)));
			if (!ur.existsByUsername("chofer"))
				ur.save(new Usuario(null, "chofer", enc.encode("chofer123"), "Cho", "Fer", "chofer@demo.cl", true,
						Set.of(chofer)));
		};
	}
}
