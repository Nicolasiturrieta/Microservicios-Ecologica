package gestionresiduos_MaterialService.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import gestionresiduos_MaterialService.demo.model.TipoCarga;
import gestionresiduos_MaterialService.demo.service.TipoCargaService;

@RestController
@RequestMapping("/tipos-carga")
public class TipoCargaController {
    private final TipoCargaService svc;

    public TipoCargaController(TipoCargaService s) {
        this.svc = s;
    }

    @PostMapping
    public TipoCarga crear(@RequestBody TipoCarga t) {
        return svc.crear(t);
    }

    @GetMapping
    public List<TipoCarga> listar() {
        return svc.listar();
    }
}

