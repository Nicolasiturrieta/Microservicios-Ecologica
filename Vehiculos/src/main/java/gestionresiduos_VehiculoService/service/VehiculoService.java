package gestionresiduos_VehiculoService.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import gestionresiduos_VehiculoService.model.Vehiculo;
import gestionresiduos_VehiculoService.repository.VehiculoRepository;

@Service
public class VehiculoService {
    private final VehiculoRepository repo;

    public VehiculoService(VehiculoRepository r) {
        this.repo = r;
    }

    public Vehiculo crear(Vehiculo v) {
        return repo.save(v);
    }

    public List<Vehiculo> listar() {
        return repo.findAll();
    }

    public Optional<Vehiculo> porId(Long id) {
        return repo.findById(id);
    }
}
