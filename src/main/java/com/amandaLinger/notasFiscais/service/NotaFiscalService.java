package com.amandaLinger.notasFiscais.service;

import com.amandaLinger.notasFiscais.ValidacaoException;
import com.amandaLinger.notasFiscais.dto.ItemNotaFiscalDto;
import com.amandaLinger.notasFiscais.dto.NotaFiscalDto;
import com.amandaLinger.notasFiscais.model.ClienteModel;
import com.amandaLinger.notasFiscais.model.ItemNotaFiscalModel;
import com.amandaLinger.notasFiscais.model.NotaFiscalModel;
import com.amandaLinger.notasFiscais.model.ProdutoModel;
import com.amandaLinger.notasFiscais.repository.ClienteRepository;
import com.amandaLinger.notasFiscais.repository.ItemNotaFiscalRepository;
import com.amandaLinger.notasFiscais.repository.NotaFiscalRepository;
import com.amandaLinger.notasFiscais.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class NotaFiscalService {

    @Autowired
    private NotaFiscalRepository notaFiscalRepository;

    @Autowired
    private ItemNotaFiscalRepository itemNotaFiscalRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private ProdutoRepository produtoRepository;

    public void createNotaFiscal(NotaFiscalDto notaFiscalDto) {
        ClienteModel cliente = clienteRepository.findByCodigo(
                        Long.valueOf(notaFiscalDto.getCodigoCliente()))
                .orElseThrow(() -> new ValidacaoException("Cliente não encontrado"));


        NotaFiscalModel numeroNota = notaFiscalRepository.findById(notaFiscalDto.getNumeroNotaFiscal())
                .orElseThrow(() -> new ValidacaoException("numero de nota fiscal já existente"));

        NotaFiscalModel notaFiscal =  new NotaFiscalModel();
        notaFiscal.setNumeroNotaFiscal(numeroNota.getId());
        notaFiscal.setData(notaFiscalDto.getData());

        for (ItemNotaFiscalDto itemDto : notaFiscalDto.getItens()) {
            ItemNotaFiscalModel item = new ItemNotaFiscalModel();
            item.setQuantidade(itemDto.getQuantidade());

            ProdutoModel produto = produtoRepository.findById(itemDto.getProdutoId())
                    .orElseThrow(() -> new ValidacaoException("Produto não encontrado"));

            item.setProduto(produto);
            item.setPrecoUnitario(produto.getPreco());
            item.setNotaFiscal(notaFiscal);
            notaFiscal.getItens().add(item);
        }
        notaFiscal.setCliente(cliente);

        notaFiscalRepository.save(notaFiscal);

    }


    @Transactional
    public void deleteNota(Long id) {
        notaFiscalRepository.deleteById(id);
    }

    @Transactional
    public void updateNota(Long id, List<ItemNotaFiscalDto> itens) {
        NotaFiscalModel notaFiscal = notaFiscalRepository.findById(id)
                .orElseThrow(() -> new ValidacaoException("Nota não encontrada"));


        for (ItemNotaFiscalDto itemDto : itens) {
            ItemNotaFiscalModel item = new ItemNotaFiscalModel();
            item.setPrecoUnitario(produtoRepository.findByPreco(itemDto.getProdutoId()));
            item.setQuantidade(itemDto.getQuantidade());
            item.setNotaFiscal(notaFiscal);
            notaFiscal.getItens().add(item);
        }

        notaFiscalRepository.save(notaFiscal);
    }

    public List<NotaFiscalModel> findAll() {
        return notaFiscalRepository.findAll();

    }

    public NotaFiscalModel findById(Long id) {
        return  notaFiscalRepository.findById(id).get();
    }
}
