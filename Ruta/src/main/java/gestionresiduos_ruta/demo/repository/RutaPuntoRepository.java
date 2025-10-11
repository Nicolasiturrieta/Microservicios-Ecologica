package gestionresiduos_ruta.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import gestionresiduos_ruta.demo.model.RutaPunto;

public interface RutaPuntoRepository extends JpaRepository<RutaPunto,Long>{
  List<RutaPunto> findByRutaIdOrderByOrdenAsc(Long rutaId);
}
