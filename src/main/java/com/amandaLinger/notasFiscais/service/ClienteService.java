package com.amandaLinger.notasFiscais.service;


import com.amandaLinger.notasFiscais.dto.ClienteDto;
import com.amandaLinger.notasFiscais.model.ClienteModel;
import com.amandaLinger.notasFiscais.repository.ClienteRepository;
import jakarta.validation.Valid;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;

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
    public void createCliente(@RequestBody @Valid ClienteDto clienteDto) throws BadRequestException {
        ClienteModel cliente = clienteRepository.findByCodigo(clienteDto.getCodigo())
                .orElse(null);

        if(cliente != null){
            throw new BadRequestException("Cliente ja cadastrado em esse código");
        }

        clienteRepository.save(ClienteModel.builder()
                        .nome(clienteDto.getNome())
                .codigo(clienteDto.getCodigo())
                .build());
    }

    //deletando cliente
    public void deleteCliente(Long id){
        clienteRepository.deleteById(id);
    }
}
