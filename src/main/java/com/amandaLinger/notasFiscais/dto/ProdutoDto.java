package com.amandaLinger.notasFiscais.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class ProdutoDto {
    @NotBlank
    private String nome;

    @NotNull
    private Double preco;

    private String descricao;

}
