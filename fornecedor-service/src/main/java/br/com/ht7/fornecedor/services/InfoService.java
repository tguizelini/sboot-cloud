package br.com.ht7.fornecedor.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ht7.fornecedor.models.InfoFornecedor;
import br.com.ht7.fornecedor.repositories.InfoRepository;

import java.util.List;
import java.util.Optional;

@Service
public class InfoService {

	@Autowired
	private InfoRepository repository;
	
	public List<InfoFornecedor> getInfoPorEstado(String estado) {
		return repository.findByEstado(estado);
	}

	public List<InfoFornecedor> all() {
		return repository.findAll();
	}

	public Optional<InfoFornecedor> getInfoPorId(String id) {
		return repository.findById(id);
	}

	public void delete(String id) {
		repository.deleteById(id);
	}
}
