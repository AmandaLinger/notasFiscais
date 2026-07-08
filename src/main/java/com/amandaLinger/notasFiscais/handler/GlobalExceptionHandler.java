package com.amandaLinger.notasFiscais.handler;

import com.amandaLinger.notasFiscais.ValidacaoException;
import com.amandaLinger.notasFiscais.dto.RespostaErroDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ValidacaoException.class)
    public ResponseEntity<RespostaErroDto> handleValidacaoException(
            ValidacaoException ex) {

        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(new RespostaErroDto(
                        ex.getMessage(),
                        HttpStatus.NOT_FOUND.value()
                ));
    }
}
