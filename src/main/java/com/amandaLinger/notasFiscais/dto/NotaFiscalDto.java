package com.amandaLinger.notasFiscais.dto;

import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class NotaFiscalDto {

    private Long numeroNotaFiscal;

    private Integer codigoCliente;

    private List<ItemNotaFiscalDto> itens;

}
