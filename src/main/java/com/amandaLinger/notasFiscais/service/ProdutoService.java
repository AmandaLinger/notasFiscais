package com.amandaLinger.notasFiscais.service;

import com.amandaLinger.notasFiscais.dto.ProdutoDto;
import com.amandaLinger.notasFiscais.model.ProdutoModel;
import com.amandaLinger.notasFiscais.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Service
@Validated
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public void createProduto(ProdutoDto produtoDto) {
        ProdutoModel produto = ProdutoModel.builder()
                .nome(produtoDto.nome())
                .preco(produtoDto.preco())
                .descricao(produtoDto.descricao())
                .build();

        produtoRepository.save(produto);
    }

    public List<ProdutoDto> getAllProdutos() {
        return  produtoRepository.getAllProdutos();
    }
}
