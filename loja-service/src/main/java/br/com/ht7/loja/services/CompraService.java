package br.com.ht7.loja.services;

import br.com.ht7.loja.clients.FornecedorClient;
import br.com.ht7.loja.dtos.CompraDTO;
import br.com.ht7.loja.dtos.InfoFornecedorDTO;
import br.com.ht7.loja.dtos.InfoPedidoDTO;
import br.com.ht7.loja.models.Compra;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class CompraService {
    @Autowired
    private FornecedorClient fornecedorClient;

    public Compra realizaCompra(CompraDTO compra) {
        final String estado = compra.getEndereco().getEstado();

        List<InfoFornecedorDTO> infoTmp = fornecedorClient.getFornecedorPorEstado(estado);

        InfoPedidoDTO infoPedido = fornecedorClient.realizaPedido(compra.getItems());

        InfoFornecedorDTO info = infoTmp.get(0); // pego o primeiro

        Compra compraSalva = new Compra();
        compraSalva.setPedidoId(infoPedido.getId());
        compraSalva.setTempoDePreparo(infoPedido.getTempoDePreparo());
        compraSalva.setEnderecoDestino(info.getEndereco());

        log.info(info.getEndereco());

        return compraSalva;
    }
}
