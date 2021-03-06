package br.com.ht7.loja.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class CompraDTO {
    private List<ItemDaCompraDTO> items;
    private EnderecoDTO endereco;
}
