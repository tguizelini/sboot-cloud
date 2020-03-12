package br.com.ht7.loja.controllers;

import br.com.ht7.loja.dtos.CompraDTO;
import br.com.ht7.loja.services.CompraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/compras")
public class CompraController {
    @Autowired
    private CompraService service;

    @GetMapping
    public String message() {
        return "funcionando..";
    }

    @PostMapping
    public void realizaCompra(@RequestBody CompraDTO compra) {
        service.realizaCompra(compra);
    }
}
