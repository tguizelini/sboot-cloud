package br.com.ht7.fornecedor.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import br.com.ht7.fornecedor.dtos.ItemDoPedidoDTO;
import br.com.ht7.fornecedor.models.Pedido;
import br.com.ht7.fornecedor.services.PedidoService;

@RestController
@RequestMapping("/pedido")
public class PedidoController {
	@Autowired
	private PedidoService pedidoService;
	
	@PostMapping
	public Pedido realizaPedido(@RequestBody List<ItemDoPedidoDTO> produtos) {
		return pedidoService.realizaPedido(produtos);
	}
	
	@GetMapping("/{id}")
	public Pedido getPedidoPorId(@PathVariable String id) {
		return pedidoService.getPedidoPorId(id);
	}
}
