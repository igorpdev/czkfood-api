package com.igorpdev.czkfoodapi.api.exceptionhandler;

import java.time.LocalDateTime;

import com.igorpdev.czkfoodapi.domain.exception.EntidadeEmUsoException;
import com.igorpdev.czkfoodapi.domain.exception.EntidadeNaoEncontradaException;
import com.igorpdev.czkfoodapi.domain.exception.NegocioException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ApiExceptionHandler {
    
    @ExceptionHandler(EntidadeNaoEncontradaException.class)
    public ResponseEntity<?> handleEntidadeNaoEncontradaException(EntidadeNaoEncontradaException e) {
        Problema problema = Problema.builder()
            .dataHora(LocalDateTime.now())
            .mensagem(e.getMessage()).build();

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(problema);
    }

    @ExceptionHandler(EntidadeEmUsoException.class)
    public ResponseEntity<?> handleEntidadeEmUsoException(EntidadeEmUsoException e) {
        Problema problema = Problema.builder()
            .dataHora(LocalDateTime.now())
            .mensagem(e.getMessage()).build();

        return ResponseEntity.status(HttpStatus.CONFLICT).body(problema);
    }

    @ExceptionHandler(NegocioException.class)
    public ResponseEntity<?> handleNegocioException(NegocioException e) {
        Problema problema = Problema.builder()
            .dataHora(LocalDateTime.now())
            .mensagem(e.getMessage()).build();

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(problema);
    }

    @ExceptionHandler(HttpMediaTypeNotSupportedException.class)
    public ResponseEntity<?> handleHttpMediaTypeNotSupportedException() {
        Problema problema = Problema.builder()
            .dataHora(LocalDateTime.now())
            .mensagem("O tipo de mídia não é aceito").build();

        return ResponseEntity.status(HttpStatus.UNSUPPORTED_MEDIA_TYPE).body(problema);
    }
    

}
