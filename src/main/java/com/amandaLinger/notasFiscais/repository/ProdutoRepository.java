package com.amandaLinger.notasFiscais.repository;

import com.amandaLinger.notasFiscais.dto.ProdutoDto;
import com.amandaLinger.notasFiscais.model.ProdutoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.NativeQuery;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface ProdutoRepository extends JpaRepository<ProdutoModel,Long> {
    @NativeQuery(value = """
        SELECT p.nome nomeProduto,
               p.preco precoProduto,
               p.descricao descricaoProduto
    FROM Produtos p
""")
    List<ProdutoDto> getAllProdutos();

}
