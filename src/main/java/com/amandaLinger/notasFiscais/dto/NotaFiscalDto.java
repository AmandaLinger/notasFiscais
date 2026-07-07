package com.amandaLinger.notasFiscais.dto;

import lombok.*;

import java.time.LocalDate;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class NotaFiscalDto {

    private Long numeroNotaFiscal;

    private LocalDate data;

    private Integer codigoCliente;

    private List<ItemNotaFiscalDto> itens;

}
