package com.amandaLinger.notasFiscais.dto;

import jakarta.validation.constraints.NotNull;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class ItemNotaFiscalDto {

    @NotNull
    private Long produtoId;
    @NotNull
    private Integer quantidade;
}
