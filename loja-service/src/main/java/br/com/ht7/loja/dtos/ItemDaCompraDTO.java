package br.com.ht7.loja.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ItemDaCompraDTO {
    private long id;
    private int quantidade;
}
