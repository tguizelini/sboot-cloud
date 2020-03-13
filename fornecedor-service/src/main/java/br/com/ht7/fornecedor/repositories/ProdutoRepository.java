package br.com.ht7.fornecedor.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.ht7.fornecedor.models.Produto;

public interface ProdutoRepository extends MongoRepository<Produto, String> {
	List<Produto> findByEstado(String estado);
	List<Produto> findByIdIn(List<String> ids);
}
