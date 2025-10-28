package gestionresiduos_ruta.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import gestionresiduos_ruta.demo.model.RutaPunto;
import gestionresiduos_ruta.demo.service.RutaService;

@RestController
@RequestMapping("/ruta-puntos")
class RutaPuntoController {
    private final RutaService svc;

    public RutaPuntoController(RutaService s) {
        this.svc = s;
    }

    @PostMapping
    public RutaPunto agregar(@RequestBody RutaPunto rp) {
        return svc.agregarPunto(rp);
    }

    @GetMapping
    public List<RutaPunto> porRuta(@RequestParam Long rutaId) {
        return svc.puntos(rutaId);
    }
}
