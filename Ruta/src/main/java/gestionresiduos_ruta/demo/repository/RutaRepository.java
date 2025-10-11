package gestionresiduos_ruta.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import gestionresiduos_ruta.demo.model.Ruta;

public interface RutaRepository extends JpaRepository<Ruta, Long> {
}
