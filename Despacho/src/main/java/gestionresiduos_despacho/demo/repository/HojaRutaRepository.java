package gestionresiduos_despacho.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import gestionresiduos_despacho.demo.model.HojaRuta;

public interface HojaRutaRepository extends JpaRepository<HojaRuta, Long> {
    List<HojaRuta> findByFecha(java.time.LocalDate f);
}
