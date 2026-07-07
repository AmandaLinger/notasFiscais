package com.amandaLinger.notasFiscais.controller;

import com.amandaLinger.notasFiscais.dto.ClienteDto;
import com.amandaLinger.notasFiscais.model.ClienteModel;
import com.amandaLinger.notasFiscais.service.ClienteService;
import jakarta.validation.Valid;
import jakarta.websocket.server.PathParam;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cliente")
@Validated
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping
    public List<ClienteModel> listarTodosClientes(){
        return clienteService.getAllClientes();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void criandoCliente(@RequestBody @Valid ClienteDto clienteDto) throws BadRequestException {
        clienteService.createCliente(clienteDto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public String removerCliente(@PathVariable Long id){
        clienteService.deleteCliente(id);
        return  "Cliente deletado com sucesso";
    }
}
