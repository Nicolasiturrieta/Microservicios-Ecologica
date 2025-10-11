package gestionresiduos_Clientes.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import gestionresiduos_Clientes.model.Cliente;
import gestionresiduos_Clientes.repository.ClienteRepository;

@Service
public class ClienteService {
    private final ClienteRepository repo;

    public ClienteService(ClienteRepository r) {
        this.repo = r;
    }

    public Cliente crear(Cliente c) {
        return repo.save(c);
    }

    public List<Cliente> listar() {
        return repo.findAll();
    }

    public Optional<Cliente> porId(Long id) {
        return repo.findById(id);
    }

    public Cliente actualizar(Long id, Cliente c) {
        c.setId(id);
        return repo.save(c);
    }

    public void eliminar(Long id) {
        repo.deleteById(id);
    }
}
