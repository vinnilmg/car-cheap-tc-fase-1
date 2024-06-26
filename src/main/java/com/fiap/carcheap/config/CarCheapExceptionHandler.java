package com.fiap.carcheap.config;

import com.fiap.carcheap.exception.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@Slf4j
@ControllerAdvice
public class CarCheapExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler({
            PedidoNotFoundException.class,
            CarroNotFoundException.class,
            ClienteNotFoundException.class,
            UserNotFoundException.class
    })
    public ResponseEntity<ApiError> handleNotFoundException(
            final Exception exception, final WebRequest request
    ) {
        final var errorCode = HttpStatus.NOT_FOUND;
        return ResponseEntity
                .status(errorCode)
                .body(new ApiError(errorCode, exception.getMessage()));
    }

    @ExceptionHandler({
            PerfilInvalidoException.class,
            UsernameAlreadyExistsException.class,
            CarroJaEstaEmProcessoDeVendaException.class,
            ClienteJaEstaEmProcessoDeVendaException.class
    })
    public ResponseEntity<ApiError> handleBusinessRulesException(
            final Exception exception, final WebRequest request
    ) {
        final var errorCode = HttpStatus.BAD_REQUEST;
        return ResponseEntity
                .status(errorCode)
                .body(new ApiError(errorCode, exception.getMessage()));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiError> handleDefaultException(
            final Exception e, final WebRequest request
    ) {
        log.error("Erro interno: {}", e.getMessage(), e);
        final var errorCode = HttpStatus.INTERNAL_SERVER_ERROR;
        return ResponseEntity
                .status(errorCode)
                .body(new ApiError(errorCode, e.getMessage()));
    }
}
