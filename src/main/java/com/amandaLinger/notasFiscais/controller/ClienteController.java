package com.amandaLinger.notasFiscais.controller;

import com.amandaLinger.notasFiscais.dto.ClienteDto;
import com.amandaLinger.notasFiscais.model.ClienteModel;
import com.amandaLinger.notasFiscais.repository.ClienteRepository;
import com.amandaLinger.notasFiscais.service.ClienteService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/cliente")
@Validated
public class ClienteController {

    private ClienteService clienteService;

    @GetMapping
    public List<ClienteModel> listarTodosClientes(){
        return clienteService.getAllClientes();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void criandoCliente(@RequestBody @Valid ClienteDto clienteDto){
        clienteService.createCliente(clienteDto);
    }
}
