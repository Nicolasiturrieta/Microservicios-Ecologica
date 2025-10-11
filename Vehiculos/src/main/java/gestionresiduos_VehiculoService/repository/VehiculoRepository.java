package gestionresiduos_VehiculoService.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import gestionresiduos_VehiculoService.model.Vehiculo;

public interface VehiculoRepository extends JpaRepository<Vehiculo, Long> {
}
