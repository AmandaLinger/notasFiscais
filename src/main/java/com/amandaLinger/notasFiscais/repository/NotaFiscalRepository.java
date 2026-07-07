package com.amandaLinger.notasFiscais.repository;

import com.amandaLinger.notasFiscais.model.NotaFiscalModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotaFiscalRepository extends JpaRepository<NotaFiscalModel,Long> {
}
