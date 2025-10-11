package gestionresiduos_VehiculoService.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import gestionresiduos_VehiculoService.model.Vehiculo;
import gestionresiduos_VehiculoService.service.VehiculoService;

@RestController
@RequestMapping("/vehiculos")
public class VehiculoController {
    private final VehiculoService svc;

    public VehiculoController(VehiculoService s) {
        this.svc = s;
    }

    @PostMapping
    public Vehiculo crear(@RequestBody Vehiculo v) {
        return svc.crear(v);
    }

    @GetMapping
    public List<Vehiculo> listar() {
        return svc.listar();
    }

    @GetMapping("/{id}")
    public Optional<Vehiculo> porId(@PathVariable Long id) {
        return svc.porId(id);
    }
}
