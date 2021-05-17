package de.thodryth.runnableExcpetionTest.test.service.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.ACCEPTED)
public class MyUncheckedException extends RuntimeException {

    public MyUncheckedException(String message) {
        super(message);
    }

}
