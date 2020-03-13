package br.com.ht7.fornecedor.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import br.com.ht7.fornecedor.enums.PedidoStatus;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ht7.fornecedor.dtos.ItemDoPedidoDTO;
import br.com.ht7.fornecedor.models.Pedido;
import br.com.ht7.fornecedor.models.PedidoItem;
import br.com.ht7.fornecedor.models.Produto;
import br.com.ht7.fornecedor.repositories.PedidoRepository;
import br.com.ht7.fornecedor.repositories.ProdutoRepository;

@Service
@Slf4j
public class PedidoService {
	@Autowired
	private PedidoRepository pedidoRepository;
	
	@Autowired
	private ProdutoRepository produtoRepository;

	public Pedido realizaPedido(List<ItemDoPedidoDTO> itens) {
		
		if(itens == null) {
			return null;
		}
		
		List<PedidoItem> pedidoItens = toPedidoItem(itens);

		Pedido pedido = new Pedido();

		pedido.setId(null);
		pedido.setStatus(PedidoStatus.RECEBIDO);
		pedido.setItens(pedidoItens);
		pedido.setTempoDePreparo(itens.size());

		log.info(pedido.toString());

		return pedidoRepository.save(pedido);
	}
	
	public Pedido getPedidoPorId(String id) {
		return this.pedidoRepository.findById(id).orElse(new Pedido());
	}

	private List<PedidoItem> toPedidoItem(List<ItemDoPedidoDTO> itens) {
		List<String> idsProdutos = new ArrayList<String>();

		itens.forEach(i -> {
			idsProdutos.add(i.getId());
		});
		
		List<Produto> produtosDoPedido = produtoRepository.findByIdIn(idsProdutos);
		
		List<PedidoItem> pedidoItens = itens
			.stream()
			.map(item -> {
				Produto produto = produtosDoPedido
						.stream()
						.filter(p -> p.getId().equals(item.getId()) )
						.findFirst()
						.get();
				
				PedidoItem pedidoItem = new PedidoItem();
				pedidoItem.setProduto(produto);
				pedidoItem.setQuantidade(item.getQuantidade());
				return pedidoItem;
			})
			.collect(Collectors.toList());

		return pedidoItens;
	}
}
