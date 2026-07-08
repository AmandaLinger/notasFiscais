package com.amandaLinger.notasFiscais.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Entity
@Table(name = "itens_nota_fiscal")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ItemNotaFiscalModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer quantidade;

    private Double precoUnitario;

    @ManyToOne
    @JoinColumn(name = "produto_id")
    private ProdutoModel produto;

    @ManyToOne
    @JoinColumn(name = "nota_fiscal_id")
    private NotaFiscalModel notaFiscal;

}
