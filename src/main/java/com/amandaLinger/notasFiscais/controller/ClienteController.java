package com.amandaLinger.notasFiscais.controller;

import com.amandaLinger.notasFiscais.dto.ClienteDto;
import com.amandaLinger.notasFiscais.model.ClienteModel;
import com.amandaLinger.notasFiscais.service.ClienteService;
import jakarta.validation.Valid;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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

    @GetMapping("/{codigo}")
    public ClienteModel listarCliente(@PathVariable Long codigo){
        return clienteService.getCliente(codigo);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String criandoCliente(@RequestBody @Valid ClienteDto clienteDto) throws BadRequestException {
        clienteService.createCliente(clienteDto);
        return "Cliente criado com sucesso";
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public String removerCliente(@PathVariable Long id){
        clienteService.deleteCliente(id);
        return  "Cliente deletado com sucesso";
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public String updateCliente(@RequestBody ClienteDto clienteDto){

        clienteService.updateCliente(clienteDto);
        return "Cliente atualizado com sucesso";
    }

}
