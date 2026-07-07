package com.amandaLinger.notasFiscais.service;

import com.amandaLinger.notasFiscais.dto.ProdutoDto;
import com.amandaLinger.notasFiscais.model.ProdutoModel;
import com.amandaLinger.notasFiscais.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;
import java.util.Optional;

@Service
@Validated
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public void createProduto(ProdutoDto produtoDto) {
        ProdutoModel produto = produtoRepository.findByNome(produtoDto.getNome())
                .orElse(null);

        if(produto != null){
            throw new IllegalStateException("Produto já existente com esse nome.");
        }

        produto = ProdutoModel.builder()
                .nome(produtoDto.getNome())
                .preco(produtoDto.getPreco())
                .descricao(produtoDto.getDescricao())
                .build();

        produtoRepository.save(produto);
    }

    public List<ProdutoDto> getAllProdutos() {
        return  produtoRepository.getAllProdutos();
    }
}
