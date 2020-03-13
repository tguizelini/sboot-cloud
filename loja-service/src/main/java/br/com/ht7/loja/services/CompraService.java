package br.com.ht7.loja.services;

import br.com.ht7.loja.clients.FornecedorClient;
import br.com.ht7.loja.dtos.CompraDTO;
import br.com.ht7.loja.dtos.InfoFornecedorDTO;
import br.com.ht7.loja.dtos.InfoPedidoDTO;
import br.com.ht7.loja.models.Compra;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class CompraService {
    @Autowired
    private FornecedorClient fornecedorClient;

    @HystrixCommand(fallbackMethod = "realizaCompraFallback")
    public Compra realizaCompra(CompraDTO compra) {
        final String estado = compra.getEndereco().getEstado();

        log.info(compra.toString());

        List<InfoFornecedorDTO> infoTmp = fornecedorClient.getFornecedorPorEstado(estado);

        InfoPedidoDTO infoPedido = fornecedorClient.realizaPedido(compra.getItems());

        InfoFornecedorDTO info = new InfoFornecedorDTO();
        info.setEndereco(infoTmp.get(0).getEndereco()); // pego o primeiro

        log.info(info.toString());

        Compra novaCompra = new Compra();

        novaCompra.setPedidoId(infoPedido.getId());
        novaCompra.setTempoDePreparo(infoPedido.getTempoDePreparo());
        novaCompra.setEnderecoDestino(info.getEndereco());

        log.info(info.getEndereco());

        return novaCompra;
    }

    private Compra realizaCompraFallback(CompraDTO compra) {
        Compra novaCompra = new Compra();

        novaCompra.setEnderecoDestino(compra.getEndereco().toString());
        novaCompra.setPedidoId(null);
        novaCompra.setTempoDePreparo(null);

        return novaCompra;
    }
}
