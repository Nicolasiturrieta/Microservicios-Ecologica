package gestionresiduos_despacho.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import gestionresiduos_despacho.demo.model.OrdenServicio;

public interface OrdenServicioRepository extends JpaRepository<OrdenServicio, Long> {
    List<OrdenServicio> findByHojaRutaId(Long id);
}
