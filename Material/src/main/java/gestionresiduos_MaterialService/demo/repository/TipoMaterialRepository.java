package gestionresiduos_MaterialService.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import gestionresiduos_MaterialService.demo.model.TipoMaterial;

public interface TipoMaterialRepository extends JpaRepository<TipoMaterial, Long> {
}