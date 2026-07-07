package com.amandaLinger.notasFiscais.controller;

import com.amandaLinger.notasFiscais.dto.NotaFiscalDto;
import com.amandaLinger.notasFiscais.model.NotaFiscalModel;
import com.amandaLinger.notasFiscais.service.NotaFiscalService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/notaFiscal")
public class NotaFiscalController {

    @Autowired
    private NotaFiscalService  notaFiscalService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String createNotaFiscal(@RequestBody @Valid NotaFiscalDto notaFiscalDto) {
        notaFiscalService.createNotaFiscal(notaFiscalDto);
        return "Nota criada com sucesso";
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public String deleteNota(@PathVariable Long id){
        notaFiscalService.deleteNota(id);
        return "Nota deletada com sucesso";
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public String updateNota(@RequestBody @Valid NotaFiscalDto notaFiscalDto) {
        notaFiscalService.updateNota(notaFiscalDto);
        return "Nota atualizada com sucesso";
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<NotaFiscalModel> findAllNotaFiscal(){
        return notaFiscalService.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public NotaFiscalModel findNotaFiscal(@PathVariable Long id){
        return notaFiscalService.findById(id);
    }
}
