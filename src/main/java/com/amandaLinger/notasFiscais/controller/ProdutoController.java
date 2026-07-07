package com.amandaLinger.notasFiscais.controller;

import com.amandaLinger.notasFiscais.dto.ProdutoDto;
import com.amandaLinger.notasFiscais.service.ProdutoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produtos")
@Validated
public class ProdutoController {
    @Autowired
    private ProdutoService produtoService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ProdutoDto> listarTodosProdutos(){
        return produtoService.getAllProdutos();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void cadastrarProduto(@RequestBody @Valid ProdutoDto produtoDto) throws Exception {
        produtoService.createProduto(produtoDto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public String deleteProduto(@PathVariable Long id){
        produtoService.deleteProduto(id);
        return "Produto excuídp";
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public void atualizarProduto(@RequestBody @Valid ProdutoDto produtoDto){
        produtoService.updateProduto(produtoDto);
    }
}
