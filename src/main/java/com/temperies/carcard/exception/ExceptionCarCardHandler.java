package com.temperies.carcard.exception;

import com.temperies.carcard.dto.ErrorDTO;
import com.temperies.carcard.dto.ValidFieldErrorDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.validation.ValidationException;
import java.io.IOError;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class ExceptionCarCardHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorDTO> error(ResourceNotFoundException exception) {
        return new ResponseEntity<>(
                new ErrorDTO(
                        "resource_not_found_error",
                        exception.getMessage(),
                        exception.getAdditionalData()),
                HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(SQLException.class)
    public ResponseEntity<ErrorDTO> error(SQLException exception) {
        return new ResponseEntity<>(
                new ErrorDTO(
                        "data_error",
                        "Cannot make data operation"),
                HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorDTO> error(
            MethodArgumentNotValidException exception) {

        BindingResult bindingResult = exception.getBindingResult();
        List<FieldError> errors = bindingResult.getFieldErrors();
        List<ValidFieldErrorDTO> validList = new ArrayList<>();

        for (FieldError fe : errors) {
            validList.add( new ValidFieldErrorDTO( fe.getField(), fe.getDefaultMessage() ) );
        }


        return new ResponseEntity<>(
                new ErrorDTO(
                        "validation_error",
                        "Some data are invalid",
                        validList),
                HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(IOException.class)
    public ResponseEntity<ErrorDTO> error(IOException exception) {
        return new ResponseEntity<>(
                new ErrorDTO(
                        "image_error",
                        "Cannot make image operation"),
                HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorDTO> error(Exception exception) {
        exception.printStackTrace();
        return new ResponseEntity<>(
                new ErrorDTO(
                        "general_error",
                        "Impossible make operation"),
                HttpStatus.BAD_REQUEST);
    }

}