package br.com.ht7.fornecedor;

import br.com.ht7.fornecedor.documents.Fornecedor;
import br.com.ht7.fornecedor.repositories.FornecedorRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@EnableEurekaClient
@Slf4j
public class FornecedorApplication {

	public static void main(String[] args) {
		SpringApplication.run(FornecedorApplication.class, args);
	}

	@Bean
	CommandLineRunner seed(FornecedorRepository repository) {
		return args -> {
			repository.deleteAll();
			log.info("Fornecedores excluídos");

			List<Fornecedor> fornecedores = new ArrayList<>();
			fornecedores.add(new Fornecedor(null, "Ambev", "GO", "Rua da Maria"));
			fornecedores.add(new Fornecedor(null, "Ambev", "SP", "Rua do João"));
			fornecedores.add(new Fornecedor(null, "Carrefour", "AM", "Rua da Onça"));
			fornecedores.add(new Fornecedor(null, "Heineken", "SP", "Rua da breja"));

			repository.saveAll(fornecedores);
			log.info("Fornecedores incluídos");
		};
	}

	@Bean
	@LoadBalanced
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
}
