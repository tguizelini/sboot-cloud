package br.com.ht7.fornecedor.services;

import br.com.ht7.fornecedor.documents.Fornecedor;
import br.com.ht7.fornecedor.repositories.FornecedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@Service
public class FornecedorService {
    @Autowired
    private FornecedorRepository repository;

    public List<Fornecedor> all() {
        return repository.findAll();
    }

    public Optional<Fornecedor> getInfoPorId(String id) {
        return repository.findById(id);
    }

    public List<Fornecedor> getInfoPorEstado(String estado) {
        return repository.findByEstado(estado);
    }

    public void delete(String id) {
        repository.deleteById(id);
    }
}
