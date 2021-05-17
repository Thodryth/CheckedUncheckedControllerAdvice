package de.thodryth.runnableExcpetionTest.test.controller.config;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import de.thodryth.runnableExcpetionTest.test.service.exceptions.MyCheckedException;
import de.thodryth.runnableExcpetionTest.test.service.exceptions.MyUncheckedException;

@ControllerAdvice
public class ControllerAdviceHandler {

    @ResponseStatus(HttpStatus.ACCEPTED)
    @ExceptionHandler(value = MyCheckedException.class)
    public ResponseEntity<String> handleMyCheckedException(MyCheckedException myCheckedException) {
        return new ResponseEntity<>("Controller Advice works and throws checked Exception", HttpStatus.ACCEPTED);
    }

    @ResponseStatus(HttpStatus.OK)
    @ExceptionHandler(value = MyUncheckedException.class)
    public ResponseEntity<String> handleMyUncheckedException(MyUncheckedException myCheckedException) {
        return new ResponseEntity<>("Controller Advice works and throws unchecked Exception", HttpStatus.OK);
    }
}
