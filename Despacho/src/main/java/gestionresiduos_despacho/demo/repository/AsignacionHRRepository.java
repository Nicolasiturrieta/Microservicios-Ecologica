package gestionresiduos_despacho.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import gestionresiduos_despacho.demo.model.AsignacionHR;

public interface AsignacionHRRepository extends JpaRepository<AsignacionHR, Long> {
    List<AsignacionHR> findByHojaRutaId(Long id);
}
