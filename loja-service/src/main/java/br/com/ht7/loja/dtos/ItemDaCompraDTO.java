package br.com.ht7.loja.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ItemDaCompraDTO {
    private String id;
    private int quantidade;
}
