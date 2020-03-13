package br.com.ht7.fornecedor.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document
public class Produto {
	@Id
	private String id;
	private String nome;
	private String estado;
	private String descricao;
	private BigDecimal preco;
}
