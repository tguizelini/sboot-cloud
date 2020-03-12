package br.com.ht7.fornecedor.controllers;

import br.com.ht7.fornecedor.documents.Fornecedor;
import br.com.ht7.fornecedor.services.FornecedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/fornecedores")
public class FornecedorController {
    @Autowired
    private FornecedorService service;

    @GetMapping
    public List<Fornecedor> getInfoPorEstado() {
        return service.all();
    }

    @GetMapping("/id/{id}")
    public Optional<Fornecedor> getInfoPorId(@PathVariable String id) {
        return service.getInfoPorId(id);
    }

    @GetMapping("/estado/{estado}")
    public List<Fornecedor> getInfoPorEstado(@PathVariable  String estado) {
        return service.getInfoPorEstado(estado);
    }

    @DeleteMapping("/id/{id}")
    public void deleteFornecedor(@PathVariable  String id) {
        service.delete(id);
    }
}
