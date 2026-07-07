package com.amandaLinger.notasFiscais.service;

import com.amandaLinger.notasFiscais.dto.NotaFiscalDto;
import com.amandaLinger.notasFiscais.model.NotaFiscalModel;
import com.amandaLinger.notasFiscais.repository.NotaFiscalRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotaFiscalService {

    @Autowired
    private NotaFiscalRepository notaFiscalRepository;

    public void createNotaFiscal(NotaFiscalDto notaFiscalDto) {
        NotaFiscalModel notaFiscal =  new NotaFiscalModel();
        notaFiscal.setNumeroNotaFiscal(notaFiscalDto.getNumeroNotaFiscal());
        notaFiscal.setData(notaFiscalDto.getData());
        notaFiscal.setItens(notaFiscal.getItens());
        notaFiscal.setCliente(notaFiscal.getCliente());

        notaFiscalRepository.save(notaFiscal);

    }


    public void deleteNota(Long id) {
        notaFiscalRepository.deleteById(id);
    }

    public void updateNota( NotaFiscalDto notaFiscalDto) {
        NotaFiscalModel notaFiscal =  new NotaFiscalModel();
        notaFiscal.setNumeroNotaFiscal(notaFiscalDto.getNumeroNotaFiscal());
        notaFiscal.setData(notaFiscalDto.getData());
        notaFiscal.setItens(notaFiscal.getItens());
        notaFiscal.setCliente(notaFiscal.getCliente());

        notaFiscalRepository.save(notaFiscal);
    }

    public List<NotaFiscalModel> findAll() {
        return notaFiscalRepository.findAll();

    }

    public NotaFiscalModel findById(Long id) {
        return  notaFiscalRepository.findById(id).get();
    }
}
