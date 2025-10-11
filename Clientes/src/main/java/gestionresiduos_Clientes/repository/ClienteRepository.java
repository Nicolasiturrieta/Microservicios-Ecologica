package gestionresiduos_Clientes.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import gestionresiduos_Clientes.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
