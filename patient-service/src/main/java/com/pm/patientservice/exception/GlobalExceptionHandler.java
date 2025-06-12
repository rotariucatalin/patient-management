package com.pm.patientservice.exception;

import com.pm.patientservice.dto.ErrorDTO;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ObjectDtoNotValidException.class)
    public ResponseEntity<ErrorDTO> handleObjectNotValid(ObjectDtoNotValidException ex,
                                                         HttpServletRequest request) {

        ErrorDTO errorDTO = new ErrorDTO(ex.getMessage(), HttpStatus.BAD_REQUEST.toString());
        return ResponseEntity.badRequest().body(errorDTO);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    ResponseEntity<ErrorDTO> handleMethodArgumentNotValid(MethodArgumentNotValidException ex) {

        ErrorDTO errorDTO = new ErrorDTO(ex.getMessage(), HttpStatus.BAD_REQUEST.toString());
        return ResponseEntity.badRequest().body(errorDTO);
    }

}
