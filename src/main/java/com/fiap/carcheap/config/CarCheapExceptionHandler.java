package com.fiap.carcheap.config;

import com.fiap.carcheap.exception.ApiError;
import com.fiap.carcheap.exception.PedidoNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CarCheapExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(PedidoNotFoundException.class)
    public ResponseEntity<ApiError> handlePedidoNotFoundException(
            final PedidoNotFoundException exception, final WebRequest request
    ) {
        final var errorCode = HttpStatus.NOT_FOUND;
        return ResponseEntity
                .status(errorCode)
                .body(new ApiError(errorCode, exception.getMessage()));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiError> handlerException(
            final Exception exception, final WebRequest request
    ) {
        final var errorCode = HttpStatus.INTERNAL_SERVER_ERROR;
        return ResponseEntity
                .status(errorCode)
                .body(new ApiError(errorCode, exception.getMessage()));
    }
}
