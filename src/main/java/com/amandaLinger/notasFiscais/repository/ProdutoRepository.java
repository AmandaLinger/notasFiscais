package com.amandaLinger.notasFiscais.repository;

import com.amandaLinger.notasFiscais.model.ProdutoModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<ProdutoModel,Long> {
}
