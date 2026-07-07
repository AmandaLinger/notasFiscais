package com.amandaLinger.notasFiscais.service;


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
    public void createCliente(ClienteDto clienteDto) throws RuntimeException {
        ClienteModel cliente = clienteRepository.findByCodigo(clienteDto.getCodigo())
                .orElse(null);

        if(cliente != null){
            throw new RuntimeException("Cliente ja cadastrado em esse código");
        }

        clienteRepository.save(ClienteModel.builder()
                        .nome(clienteDto.getNome())
                .codigo(clienteDto.getCodigo())
                .build());

    }

    //deletando cliente
    @Transactional
    public void deleteCliente(Long id){
        clienteRepository.deleteById(id);
    }


    //atualizando o cliente
    @Transactional
    public void updateCliente(ClienteDto clienteDto) {
        ClienteModel cliente = clienteRepository.findByCodigo(clienteDto.getCodigo())
                .orElseThrow(() -> new RuntimeException("Cliente nao encontrado"));
        cliente.setNome(clienteDto.getNome());

        clienteRepository.save(cliente);
    }

    public Optional<ClienteModel> getCliente(Long codigo) {
        clienteRepository.findByCodigo(codigo).orElseThrow(() -> new RuntimeException("Cliente nao encontrado"));

        return clienteRepository.findByCodigo(codigo);
    }
}
