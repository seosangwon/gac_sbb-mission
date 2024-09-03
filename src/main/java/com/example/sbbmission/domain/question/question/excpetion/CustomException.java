package com.example.sbbmission.domain.question.question.excpetion;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


public class CustomException {

    @ResponseStatus(value = HttpStatus.NOT_FOUND , reason = "entity not found")
    public static  class DataNotFoundException extends RuntimeException {
        public DataNotFoundException(String msg) {
            super(msg);
        }
    }
}
