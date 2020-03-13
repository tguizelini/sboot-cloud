package br.com.ht7.loja.clients;

import br.com.ht7.loja.dtos.InfoFornecedorDTO;
import br.com.ht7.loja.dtos.InfoPedidoDTO;
import br.com.ht7.loja.dtos.ItemDaCompraDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@FeignClient("fornecedor")
public interface FornecedorClient {
    @GetMapping("info/estado/{estado}")
    List<InfoFornecedorDTO> getFornecedorPorEstado(@PathVariable String estado);

    @PostMapping("/pedido")
    InfoPedidoDTO realizaPedido(List<ItemDaCompraDTO> itens);
}
