package br.com.ht7.loja.services;

import br.com.ht7.loja.dtos.CompraDTO;
import br.com.ht7.loja.dtos.InfoFornecedorDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
@Slf4j
public class CompraService {
    @Autowired
    private RestTemplate restTemplate;

    public void realizaCompra(CompraDTO compra) {
        String url = "http://fornecedor/api/fornecedores/estado/" + compra.getEndereco().getEstado();

        ResponseEntity<InfoFornecedorDTO[]> response = restTemplate.getForEntity(url, InfoFornecedorDTO[].class);

        log.info(response.getStatusCode().toString());

        if (response.getBody().length > 0) {
            List<InfoFornecedorDTO> fornecedores = Arrays.asList( response.getBody() );

            fornecedores.forEach(e -> {
                log.info(e.getEndereco());
            });
        }
    }
}
