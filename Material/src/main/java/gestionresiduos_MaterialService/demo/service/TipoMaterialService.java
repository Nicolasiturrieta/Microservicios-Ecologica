package gestionresiduos_MaterialService.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import gestionresiduos_MaterialService.demo.model.TipoMaterial;
import gestionresiduos_MaterialService.demo.repository.TipoMaterialRepository;

@Service
public class TipoMaterialService {
    private final TipoMaterialRepository repo;

    public TipoMaterialService(TipoMaterialRepository r) {
        this.repo = r;
    }

    public TipoMaterial crear(TipoMaterial t) {
        return repo.save(t);
    }

    public List<TipoMaterial> listar() {
        return repo.findAll();
    }
}
