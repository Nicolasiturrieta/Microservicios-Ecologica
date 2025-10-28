package gestionresiduos_Clientes.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import gestionresiduos_Clientes.model.Cliente;
import gestionresiduos_Clientes.service.ClienteService;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
    private final ClienteService svc;

    public ClienteController(ClienteService s) {
        this.svc = s;
    }

    @PostMapping
    public Cliente crear(@RequestBody Cliente c) {
        return svc.crear(c);
    }

    @GetMapping
    public List<Cliente> listar() {
        return svc.listar();
    }

    @GetMapping("/{id}")
    public Optional<Cliente> porId(@PathVariable Long id) {
        return svc.porId(id);
    }

    @PatchMapping("/{id}")
    public Cliente actualizar(@PathVariable Long id, @RequestBody Cliente c) {
        return svc.actualizar(id, c);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        svc.eliminar(id);
    }
}
