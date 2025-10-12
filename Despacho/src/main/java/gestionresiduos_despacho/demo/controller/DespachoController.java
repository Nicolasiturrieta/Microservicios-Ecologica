package gestionresiduos_despacho.demo.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import gestionresiduos_despacho.demo.dto.CerrarOsRequest;
import gestionresiduos_despacho.demo.dto.GenerarOsRequest;
import gestionresiduos_despacho.demo.model.AsignacionHR;
import gestionresiduos_despacho.demo.model.HojaRuta;
import gestionresiduos_despacho.demo.model.OrdenServicio;
import gestionresiduos_despacho.demo.service.DespachoService;

@RestController
@RequestMapping("/despacho")
public class DespachoController {
    private final DespachoService svc;

    public DespachoController(DespachoService s) {
        this.svc = s;
    }

    @PostMapping("/hojas-ruta")
    public HojaRuta crearHoja(@RequestParam Long rutaId, @RequestParam String fecha) {
        return svc.crearHoja(rutaId, LocalDate.parse(fecha));
    }

    @PostMapping("/asignaciones")
    public AsignacionHR asignar(@RequestParam Long hojaId, @RequestParam Long choferId, @RequestParam Long vehiculoId) {
        return svc.asignar(hojaId, choferId, vehiculoId);
    }

    @PostMapping("/ordenes-servicio/generar")
    public List<OrdenServicio> generar(@RequestBody GenerarOsRequest req) {
        return svc.generarOS(req.hojaRutaId(), req.puntoIds());
    }

    @GetMapping("/ordenes-servicio")
    public List<OrdenServicio> listarOs(@RequestParam Long hojaId) {
        return svc.listarOs(hojaId);
    }

    @PatchMapping("/ordenes-servicio/{id}/iniciar")
    public OrdenServicio iniciar(@PathVariable Long id) {
        return svc.iniciarOS(id);
    }

    @PatchMapping("/ordenes-servicio/{id}/cerrar")
    public OrdenServicio cerrar(@PathVariable Long id, @RequestBody CerrarOsRequest req) {
        return svc.cerrarOS(id, req.pesoKg(), req.observaciones());
    }
}
