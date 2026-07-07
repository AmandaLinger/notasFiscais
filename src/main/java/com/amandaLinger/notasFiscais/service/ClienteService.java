package com.amandaLinger.notasFiscais.service;


import com.amandaLinger.notasFiscais.dto.ClienteDto;
import com.amandaLinger.notasFiscais.model.ClienteModel;
import com.amandaLinger.notasFiscais.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Service
@Validated
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    //chamando todos clientes
    public List<ClienteModel> getAllClientes(){
        List<ClienteModel> clienteDtos = clienteRepository.findAll();
        return clienteDtos;
    }

    //criando cliente
    public void createCliente(ClienteDto clienteDto) {
        ClienteModel cliente = clienteRepository.findByCodigo(clienteDto.codigo())
                .orElse(null);

        if(cliente != null){
            throw new RuntimeException("Cliente ja cadastrado em esse código");
        }

        clienteRepository.save(ClienteModel.builder()
                        .nome(clienteDto.nome())
                .codigo(clienteDto.codigo())
                .build());
    }
}
