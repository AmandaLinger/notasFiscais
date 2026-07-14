package com.amandaLinger.notasFiscais.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
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

    private LocalDate data = LocalDate.now();
    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private ClienteModel cliente;

    @OneToMany(mappedBy = "notaFiscal",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private List<ItemNotaFiscalModel> itens = new ArrayList<>();


    private BigDecimal precoTotal;

    public BigDecimal getPrecoTotal() {
        return itens.stream()
                .map(item -> item.getQuantidade().multiply(item.getPrecoUnitario()))
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}
