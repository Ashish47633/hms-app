package com.hms.exceptionHandler;

import com.hms.exception.UserNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import javax.security.auth.login.LoginException;
import java.time.LocalDateTime;
import java.util.Date;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ErrorDto> userException(UserNotFoundException ue, WebRequest res){

        ErrorDto dto =  new ErrorDto(ue.getMessage(), LocalDateTime.now(),res.getDescription(true));
        return new ResponseEntity<ErrorDto>(dto, HttpStatus.INTERNAL_SERVER_ERROR);
    }


}
