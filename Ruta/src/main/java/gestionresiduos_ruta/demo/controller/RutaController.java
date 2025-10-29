package gestionresiduos_ruta.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import gestionresiduos_ruta.demo.model.Ruta;
import gestionresiduos_ruta.demo.service.RutaService;

@RestController
@RequestMapping("/rutas")
public class RutaController {
    private final RutaService svc;

    public RutaController(RutaService s) {
        this.svc = s;
    }

    @PostMapping
    public Ruta crear(@RequestBody Ruta r) {
        return svc.crearRuta(r);
    }

    @GetMapping
    public List<Ruta> listar() {
        return svc.listarRutas();
    }

    @GetMapping("/{id}")
    public Ruta porId(@PathVariable Long id) {
        return svc.porId(id);
    }
}
