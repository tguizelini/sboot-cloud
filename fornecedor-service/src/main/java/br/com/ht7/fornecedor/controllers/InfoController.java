package br.com.ht7.fornecedor.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import br.com.ht7.fornecedor.models.InfoFornecedor;
import br.com.ht7.fornecedor.services.InfoService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/info")
public class InfoController {
	@Autowired
	private InfoService service;
	
	@GetMapping("/estado/{estado}")
	public List<InfoFornecedor> getInfoPorEstado(@PathVariable String estado) {
		return service.getInfoPorEstado(estado);
	}

	@GetMapping
	public List<InfoFornecedor> all() {
		return service.all();
	}

	@GetMapping("/id/{id}")
	public Optional<InfoFornecedor> getInfoPorId(@PathVariable String id) {
		return service.getInfoPorId(id);
	}

	@DeleteMapping("/id/{id}")
	public void deleteFornecedor(@PathVariable  String id) {
		service.delete(id);
	}
}
