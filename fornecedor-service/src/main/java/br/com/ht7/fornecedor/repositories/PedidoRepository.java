package br.com.ht7.fornecedor.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.CrudRepository;

import br.com.ht7.fornecedor.models.Pedido;

public interface PedidoRepository extends MongoRepository<Pedido, String> {

}
