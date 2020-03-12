package br.com.ht7.fornecedor.documents;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@Document
public class Fornecedor {
    @Id
    private String id;
    private String nome;
    private String estado;
    private String endereco;
}
