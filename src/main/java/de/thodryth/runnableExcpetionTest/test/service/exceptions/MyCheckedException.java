package de.thodryth.runnableExcpetionTest.test.service.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.ACCEPTED)
public class MyCheckedException extends Exception {

    public MyCheckedException(String message) {
        super(message);
    }

}
