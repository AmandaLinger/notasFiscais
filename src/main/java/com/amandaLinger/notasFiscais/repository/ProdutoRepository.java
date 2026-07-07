package com.amandaLinger.notasFiscais.repository;

import com.amandaLinger.notasFiscais.dto.ProdutoDto;
import com.amandaLinger.notasFiscais.model.ProdutoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.NativeQuery;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;


public interface ProdutoRepository extends JpaRepository<ProdutoModel,Long> {
    @Query(value = """
    SELECT
        p.nome AS nome,
        p.preco AS preco,
        p.descricao AS descricao
    FROM Produtos p
    """, nativeQuery = true)
    List<ProdutoDto> getAllProdutos();


    Optional<ProdutoModel> findByNome(String nome);
}
