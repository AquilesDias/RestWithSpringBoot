package br.com.development.spring.restwithspringboot.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class MathException extends RuntimeException{

    public MathException(String msg){
        super(msg);
    }
}
