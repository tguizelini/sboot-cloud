package br.com.ht7.fornecedor.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReservaDTO {
	public String idReserva;
	public Integer tempoDePreparo;
}
