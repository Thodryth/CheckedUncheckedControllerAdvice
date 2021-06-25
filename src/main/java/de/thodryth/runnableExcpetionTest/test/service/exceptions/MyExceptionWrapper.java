package de.thodryth.runnableExcpetionTest.test.service.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.ACCEPTED)
public class MyExceptionWrapper extends RuntimeException {

    public MyExceptionWrapper(Throwable cause) {
        super(cause);
    }

}
