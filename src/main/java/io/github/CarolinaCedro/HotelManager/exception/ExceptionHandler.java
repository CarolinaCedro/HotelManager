package io.github.CarolinaCedro.HotelManager.exception;

import io.github.CarolinaCedro.HotelManager.errors.Errors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class ExceptionHandler extends ResponseEntityExceptionHandler {

    @Autowired
    private MessageSource messageSource;

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {

        List<Errors.Campo> campos = new ArrayList<>();
        for (ObjectError error : ex.getBindingResult().getAllErrors()) {
            String nome = ((FieldError) error).getField();
            String msg = messageSource.getMessage(error, LocaleContextHolder.getLocale());
            campos.add(new Errors.Campo(nome, msg));
        }
        Errors errors = new Errors();
        errors.setStatus(status.value());
        errors.setDataHora(LocalDate.now());
        errors.setTitulo("Um ou mais campos estão inválidos. Faça o preenchimento correto e tente novamente ");
        errors.setCampos(campos);

        return handleExceptionInternal(ex,errors,headers,status,request);
    }


    @org.springframework.web.bind.annotation.ExceptionHandler(DomainException.class)
    public ResponseEntity<Object> handleNegocio(DomainException ex, WebRequest request){
        HttpStatus status = HttpStatus.BAD_REQUEST;
        Errors errors = new Errors();
        errors.setStatus(status.value());
        errors.setDataHora(LocalDate.now());
        errors.setTitulo(ex.getMessage());
        return handleExceptionInternal(ex,errors,new HttpHeaders(),status,request);
    }

}

