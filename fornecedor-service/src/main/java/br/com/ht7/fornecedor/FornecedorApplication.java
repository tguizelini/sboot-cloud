package br.com.ht7.fornecedor;

import br.com.ht7.fornecedor.models.InfoFornecedor;
import br.com.ht7.fornecedor.models.Produto;
import br.com.ht7.fornecedor.repositories.InfoRepository;
import br.com.ht7.fornecedor.repositories.ProdutoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;
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
	CommandLineRunner seed(InfoRepository infoRepository, ProdutoRepository produtoRepository) {
		return args -> {
			//SEED FORNECEDORES
			log.info("Fornecedores excluídos");

			infoRepository.deleteAll();

			List<InfoFornecedor> fornecedores = new ArrayList<>();
			fornecedores.add(new InfoFornecedor(null, "Ambev", "GO", "Rua da Maria"));
			fornecedores.add(new InfoFornecedor(null, "Ambev", "SP", "Rua do João"));
			fornecedores.add(new InfoFornecedor(null, "Carrefour", "AM", "Rua da Onça"));
			fornecedores.add(new InfoFornecedor(null, "Heineken", "SP", "Rua da breja"));

			infoRepository.saveAll(fornecedores);

			log.info("Fornecedores incluídos");

			//SEED PRODUTOS
			log.info("Produtos excluídos");

			produtoRepository.deleteAll();

			List<Produto> produtos = new ArrayList<>();
			produtos.add(new Produto(null, "Rosa Vermelha", "GO", "Boa pra macumba", new BigDecimal("20.0") )) ;
			produtos.add(new Produto(null, "Rosa Branca", "SP", "Presente pra Iemanjá", new BigDecimal("4.50") )) ;
			produtos.add(new Produto(null, "Rosa Rosada", "AM", "Muito bom", new BigDecimal("104.00") )) ;

			produtoRepository.saveAll(produtos);

			log.info("Produtos incluídos");
		};
	}
}
