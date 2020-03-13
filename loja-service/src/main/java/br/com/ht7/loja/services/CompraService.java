package br.com.ht7.loja.services;

import br.com.ht7.loja.clients.FornecedorClient;
import br.com.ht7.loja.dtos.CompraDTO;
import br.com.ht7.loja.dtos.FornecedorDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class CompraService {
    @Autowired
    private FornecedorClient fornecedorClient;

    public void realizaCompra(CompraDTO compra) {
        List<FornecedorDTO> fornecedores = fornecedorClient.getFornecedorPorEstado(compra.getEndereco().getEstado());

        fornecedores.forEach(e -> {
            log.info("ENDEREÇO -> " + e.getEndereco());
        });
    }
}
