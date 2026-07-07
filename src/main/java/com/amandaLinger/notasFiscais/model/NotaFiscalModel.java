package com.amandaLinger.notasFiscais.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity(name = "NotaFiscal")
@Table(name = "notas_fiscais")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class NotaFiscalModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long numeroNotaFiscal;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    ClienteModel cliente;

    @OneToMany   //corrigir
    @JoinColumn(name = "produto_id" )
    List<ProdutoModel> produtos;
}
