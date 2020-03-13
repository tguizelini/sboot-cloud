package br.com.ht7.fornecedor.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document
public class PedidoItem {
	@Id
	private String id;
	private Integer quantidade;
	//@ManyToOne @JoinColumn(name = "produtoId")
	private Produto produto;
}
