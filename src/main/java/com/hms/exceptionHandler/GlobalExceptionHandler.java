package com.hms.exceptionHandler;

import com.hms.exception.CityException;
import com.hms.exception.CountryException;
import com.hms.exception.PropertyException;
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
        return new ResponseEntity<ErrorDto>(dto, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(CityException.class)
    public ResponseEntity<ErrorDto> citiesExceptionHandler(CityException c, WebRequest request){
        ErrorDto dto = new ErrorDto(c.getMessage(),LocalDateTime.now(),request.getDescription(true));
        return new ResponseEntity<ErrorDto>(dto,HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(CountryException.class)
    public ResponseEntity<ErrorDto> countryExceptionHandler(CountryException ce, WebRequest req){
        ErrorDto dto = new ErrorDto(ce.getMessage(), LocalDateTime.now(), req.getDescription(true));
        return new ResponseEntity<ErrorDto>(dto, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(PropertyException.class)
    public ResponseEntity<ErrorDto> propertyExceptionHandler(PropertyException p,WebRequest request){
        ErrorDto dto = new ErrorDto(p.getMessage(),LocalDateTime.now(),request.getDescription(true));
        return new ResponseEntity<ErrorDto>(dto,HttpStatus.BAD_REQUEST);
    }


}
