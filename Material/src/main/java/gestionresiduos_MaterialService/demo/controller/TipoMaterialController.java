package gestionresiduos_MaterialService.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import gestionresiduos_MaterialService.demo.model.TipoMaterial;
import gestionresiduos_MaterialService.demo.service.TipoMaterialService;

@RestController
@RequestMapping("/tipos-material")
public class TipoMaterialController {
    private final TipoMaterialService svc;

    public TipoMaterialController(TipoMaterialService s) {
        this.svc = s;
    }

    @PostMapping
    public TipoMaterial crear(@RequestBody TipoMaterial t) {
        return svc.crear(t);
    }

    @GetMapping
    public List<TipoMaterial> listar() {
        return svc.listar();
    }
}
