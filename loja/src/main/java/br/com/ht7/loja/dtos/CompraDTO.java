package br.com.ht7.loja.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CompraDTO {
    private List<ItemDaCompraDTO> items;
    private EnderecoDTO endereco;
}
