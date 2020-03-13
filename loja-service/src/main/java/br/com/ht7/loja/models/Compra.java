package br.com.ht7.loja.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Compra {
    private String id;
    private String pedidoId;
    private Integer tempoDePreparo;
    private String enderecoDestino;
}
