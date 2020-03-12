package br.com.ht7.fornecedor.repositories;

import br.com.ht7.fornecedor.documents.Fornecedor;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FornecedorRepository extends MongoRepository<Fornecedor, String> {
    List<Fornecedor> findByEstado(String estado);
}
