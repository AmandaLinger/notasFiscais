package com.amandaLinger.notasFiscais.controller;

import com.amandaLinger.notasFiscais.dto.ProdutoDto;
import com.amandaLinger.notasFiscais.dto.ProdutoDto4Construtores;
import com.amandaLinger.notasFiscais.model.ProdutoModel;
import com.amandaLinger.notasFiscais.service.ProdutoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produto")
@Validated
public class ProdutoController {
    @Autowired
    private ProdutoService produtoService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ProdutoModel> listarTodosProdutos(){
        return produtoService.getAllProdutos();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ProdutoModel listaProduto(@PathVariable Long id){
        return produtoService.getProduto(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String cadastrarProduto(@RequestBody @Valid ProdutoDto produtoDto){
        produtoService.createProduto(produtoDto);
        return  "Produto criado com sucesso.";
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public String deleteProduto(@PathVariable Long id){
        produtoService.deleteProduto(id);
        return "Produto excuído com sucesso.";
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public String atualizarProduto(@PathVariable Long id,
                                   @RequestBody @Valid  ProdutoDto4Construtores produtoDto4construtores){
        produtoService.updateProduto(id, produtoDto4construtores);

        return "Produto atualizado com sucesso!";
    }
}
