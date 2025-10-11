package gestionresiduos_MaterialService.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import gestionresiduos_MaterialService.demo.model.TipoCarga;

public interface TipoCargaRepository extends JpaRepository<TipoCarga, Long> {
}
