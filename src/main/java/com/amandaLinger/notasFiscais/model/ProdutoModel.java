package com.amandaLinger.notasFiscais.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Entity(name = "Produto")
@Table(name = "Produtos")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProdutoModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String nome;

    @NotNull
    private Double preco;

    private String descricao;

}
