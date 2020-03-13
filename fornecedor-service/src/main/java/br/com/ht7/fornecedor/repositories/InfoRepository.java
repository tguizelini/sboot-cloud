package br.com.ht7.fornecedor.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import br.com.ht7.fornecedor.models.InfoFornecedor;

import java.util.List;

@Repository
public interface InfoRepository extends MongoRepository<InfoFornecedor, String> {
	List<InfoFornecedor> findByEstado(String estado);
}
