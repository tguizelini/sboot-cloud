package br.com.ht7.loja.controllers;

import br.com.ht7.loja.dtos.CompraDTO;
import br.com.ht7.loja.models.Compra;
import br.com.ht7.loja.services.CompraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("compra")
public class CompraController {
    @Autowired
    private CompraService service;

    @PostMapping
    public Compra realizaCompra(@RequestBody CompraDTO compra) {
        return service.realizaCompra(compra);
    }
}
