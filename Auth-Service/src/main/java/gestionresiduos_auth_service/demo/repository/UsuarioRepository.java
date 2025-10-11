package gestionresiduos_auth_service.demo.repository;

import gestionresiduos_auth_service.demo.model.*;
import org.springframework.data.jpa.repository.*;
import java.util.*;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByNombre(String nombre);
}
