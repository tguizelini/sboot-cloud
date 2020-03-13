package br.com.ht7.fornecedor.models;

import br.com.ht7.fornecedor.enums.PedidoStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document
public class Pedido {
	@Id
	private String id;
	private Integer tempoDePreparo;
	//@Enumerated(EnumType.STRING)
	private PedidoStatus status;
	//@OneToMany(cascade = CascadeType.ALL)
	//@JoinColumn(name = "pedidoId")
	private List<PedidoItem> itens;

	public Pedido(List<PedidoItem> itens) {
		this.itens = itens;
		this.status = PedidoStatus.RECEBIDO;
	}
}
