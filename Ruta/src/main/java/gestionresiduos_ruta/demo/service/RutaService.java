package gestionresiduos_ruta.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import gestionresiduos_ruta.demo.model.Ruta;
import gestionresiduos_ruta.demo.model.RutaPunto;
import gestionresiduos_ruta.demo.repository.RutaPuntoRepository;
import gestionresiduos_ruta.demo.repository.RutaRepository;

@Service
public class RutaService {
    private final RutaRepository rRepo;
    private final RutaPuntoRepository pRepo;

    public RutaService(RutaRepository r, RutaPuntoRepository p) {
        this.rRepo = r;
        this.pRepo = p;
    }

    public Ruta crearRuta(Ruta r) {
        return rRepo.save(r);
    }

    public List<Ruta> listarRutas() {
        return rRepo.findAll();
    }

<<<<<<< HEAD
=======
    public Ruta porId(Long id) {
        return rRepo.findById(id).orElseThrow();
    }

>>>>>>> 47c8da7 (ajustes)
    public RutaPunto agregarPunto(RutaPunto rp) {
        return pRepo.save(rp);
    }

    public List<RutaPunto> puntos(Long rutaId) {
        return pRepo.findByRutaIdOrderByOrdenAsc(rutaId);
    }
<<<<<<< HEAD
}
=======
}
>>>>>>> 47c8da7 (ajustes)
