package com.amandaLinger.notasFiscais.service;


import com.amandaLinger.notasFiscais.ValidacaoException;
import com.amandaLinger.notasFiscais.dto.ClienteDto;
import com.amandaLinger.notasFiscais.model.ClienteModel;
import com.amandaLinger.notasFiscais.repository.ClienteRepository;
import com.amandaLinger.notasFiscais.repository.NotaFiscalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import java.util.List;
import java.util.Optional;

@Service
@Validated
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private NotaFiscalRepository notaFiscalRepository;

    //chamando todos clientes
    public List<ClienteModel> getAllClientes(){
        return clienteRepository.findAll();
    }

    //criando cliente
    public ClienteDto createCliente(ClienteDto clienteDto){
        ClienteModel cliente = clienteRepository.findByCodigo(clienteDto.getCodigo())
                .orElse(null);

        if(cliente != null){
            throw new ValidacaoException("Cliente ja cadastrado em esse código");
        }

        clienteRepository.save(ClienteModel.builder()
                        .nome(clienteDto.getNome())
                .codigo(clienteDto.getCodigo())
                .build());

        return clienteDto;
    }

    //deletando cliente
    @Transactional
    public void deleteCliente(Long id){
        ClienteModel cliente = clienteRepository.findById(id)
                .orElseThrow(() -> new ValidacaoException("Id não encontrado"));
    }


    //atualizando o cliente
    @Transactional //ok
    public void updateCliente(Long id, ClienteDto clienteDto) {
        ClienteModel cliente = clienteRepository.findById(id)
                .orElseThrow(() -> new ValidacaoException("Cliente não encontrado"));
        cliente.setNome(clienteDto.getNome());

        clienteRepository.save(cliente);
    }

    public ClienteModel getCliente(Long id) {
        return clienteRepository.findById(id)
                .orElseThrow(() -> new ValidacaoException("Cliente não encontrado"));
    }
}
