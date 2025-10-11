package gestionresiduos_MaterialService.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import gestionresiduos_MaterialService.demo.model.ContenedorTipo;
import gestionresiduos_MaterialService.demo.service.ContenedorTipoService;

@RestController
@RequestMapping("/contenedor-tipo")
public class ContenedorTipoController {
    private final ContenedorTipoService svc;

    public ContenedorTipoController(ContenedorTipoService s) {
        this.svc = s;
    }

    @PostMapping
    public ContenedorTipo crear(@RequestBody ContenedorTipo t) {
        return svc.crear(t);
    }

    @GetMapping
    public List<ContenedorTipo> listar() {
        return svc.listar();
    }
}

