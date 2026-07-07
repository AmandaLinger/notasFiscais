package com.amandaLinger.notasFiscais.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class ItemNotaFiscalDto {

    private Long produtoId;
    private Integer quantidade;
}
