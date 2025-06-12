package io.github.lucasiferreira.system_hospital.exceptions;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class ResourceExceptionHandler {

    @ExceptionHandler(RegistroDuplicadoException.class)
    public ResponseEntity<StandardError> resourceDuplicated(RegistroDuplicadoException e, HttpServletRequest request) {

        String error = "Usuario já cadastrado";
        HttpStatus status = HttpStatus.CONFLICT;
        StandardError standardError = new StandardError(LocalDateTime.now(), status.value(), error, request.getRequestURI());
        return ResponseEntity.status(status).body(standardError);
    }
}
