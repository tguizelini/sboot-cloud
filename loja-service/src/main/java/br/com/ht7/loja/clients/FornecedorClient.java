package br.com.ht7.loja.clients;

import br.com.ht7.loja.dtos.FornecedorDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient("fornecedor")
public interface FornecedorClient {
    @GetMapping("info/estado/{estado}")
    List<FornecedorDTO> getFornecedorPorEstado(@PathVariable String estado);
}
