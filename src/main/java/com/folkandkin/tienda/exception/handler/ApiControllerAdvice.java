package com.folkandkin.tienda.exception.handler;

import com.folkandkin.tienda.dto.response.ExceptionResponse;

import com.folkandkin.tienda.exception.RoleNameNotNullException;
import lombok.extern.slf4j.Slf4j;

import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

/**
 * Clase para controlar las excepciones.
 *
 * @version v1 17 Nov 2023
 * @author Leandro Deferrari
 */

@Slf4j
@ControllerAdvice(annotations = RestController.class)
public class ApiControllerAdvice {
    @ExceptionHandler
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ExceptionResponse validException(MethodArgumentNotValidException ex){
        List<FieldError> errors = ex.getBindingResult().getFieldErrors();

        Map<String, String> detail = new HashMap<>();

        log.info("Ocurrio una validación");

        errors.forEach(error -> {
            log.info("Atributo: " + error.getField() + " - Validación: " + error.getDefaultMessage());
            detail.put(error.getField(), error.getDefaultMessage());
        });

        return new ExceptionResponse(HttpStatus.BAD_REQUEST.value(), "Validaciones", detail);
    }

    @ExceptionHandler
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ExceptionResponse roleNameNotNullException(RoleNameNotNullException ex){
        log.info("Ocurrio una validacion de Rol: " + ex.getMessage());
        return new ExceptionResponse(
                HttpStatus.BAD_REQUEST.value(),
                ex.getMessage(),
                null
        );
    }

    @ExceptionHandler
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ExceptionResponse optionalException(NoSuchElementException ex){
        log.info("Ocurrio una validacion referido a la clase Optional de Java: " + ex.getMessage());
        return new ExceptionResponse(
                HttpStatus.BAD_REQUEST.value(),
                ex.getMessage(),
                null
        );
    }

    @ExceptionHandler
    @ResponseBody
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ExceptionResponse internalServerError(RuntimeException ex){
        Map<String, String> detail = new HashMap<>();
        detail.put("Clase", ex.getClass().getName());

        log.info("Ocurrio un error inesperado: " + ex.getMessage());
        return new ExceptionResponse(
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                ex.getMessage(),
                detail
        );
    }
}
