package gestionresiduos_MaterialService.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import gestionresiduos_MaterialService.demo.model.ContenedorTipo;
import gestionresiduos_MaterialService.demo.repository.ContenedorTipoRepository;

@Service
public class ContenedorTipoService {
    private final ContenedorTipoRepository repo;

    public ContenedorTipoService(ContenedorTipoRepository r) {
        this.repo = r;
    }

    public ContenedorTipo crear(ContenedorTipo t) {
        return repo.save(t);
    }

    public List<ContenedorTipo> listar() {
        return repo.findAll();
    }
}
