package com.amandaLinger.notasFiscais.repository;

import com.amandaLinger.notasFiscais.model.ClienteModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<ClienteModel, Long> {
}
