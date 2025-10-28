package gestionresiduos_auth_service.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import gestionresiduos_auth_service.demo.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByNombre(String nombre);
}
