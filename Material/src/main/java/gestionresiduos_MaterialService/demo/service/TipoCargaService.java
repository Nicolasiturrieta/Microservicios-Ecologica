package gestionresiduos_MaterialService.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import gestionresiduos_MaterialService.demo.model.TipoCarga;
import gestionresiduos_MaterialService.demo.repository.TipoCargaRepository;

@Service
public class TipoCargaService {
    private final TipoCargaRepository repo;

    public TipoCargaService(TipoCargaRepository r) {
        this.repo = r;
    }

    public TipoCarga crear(TipoCarga t) {
        return repo.save(t);
    }

    public List<TipoCarga> listar() {
        return repo.findAll();
    }
}
