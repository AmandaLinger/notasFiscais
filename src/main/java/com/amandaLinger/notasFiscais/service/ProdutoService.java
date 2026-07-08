package com.amandaLinger.notasFiscais.service;

import com.amandaLinger.notasFiscais.ValidacaoException;
import com.amandaLinger.notasFiscais.dto.ProdutoDto;
import com.amandaLinger.notasFiscais.dto.ProdutoDto4Construtores;
import com.amandaLinger.notasFiscais.model.ProdutoModel;
import com.amandaLinger.notasFiscais.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Service
@Validated
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public void createProduto(ProdutoDto produtoDto){
        ProdutoModel produto = produtoRepository.findByNome(produtoDto.getNome())
                .orElse(null);

        if(produto != null){
            throw new ValidacaoException("Produto já existente com esse nome.");
        }

        produto = ProdutoModel.builder()
                .nome(produtoDto.getNome())
                .preco(produtoDto.getPreco())
                .quantidade(produtoDto.getQuantidade())
                .descricao(produtoDto.getDescricao())
                .build();

        produtoRepository.save(produto);
    }

    public List<ProdutoModel> getAllProdutos() {
        return  produtoRepository.getAllProdutos();
    }

    @Transactional
    public void deleteProduto(Long id) {
        produtoRepository.deleteById(id);
    }

    @Transactional
    public String updateProduto(ProdutoDto produtoDto){
        ProdutoModel produto = produtoRepository.findById(produtoDto.getId())
                .orElseThrow(() -> new RuntimeException("Produto não encontrado"));

        produto.setNome(produtoDto.getNome());
        produto.setPreco(produtoDto.getPreco());
        produto.setDescricao(produtoDto.getDescricao());
        produto.setQuantidade(produtoDto.getQuantidade());

        produtoRepository.save(produto);

        return "Produto atualizado com sucesso!";

    }
}
