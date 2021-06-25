package de.thodryth.runnableExcpetionTest.test.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import de.thodryth.runnableExcpetionTest.test.service.exceptions.MyCheckedException;
import de.thodryth.runnableExcpetionTest.test.service.exceptions.MyExceptionWrapper;
import de.thodryth.runnableExcpetionTest.test.service.exceptions.MyUncheckedException;

@Service
public class MyService {

    Logger logger = LoggerFactory.getLogger(MyService.class);

    public void checked() throws MyCheckedException {
        throw new MyCheckedException("Controller Advice works and throws checked Exception");
    }

    public void unchecked() {
        throw new MyUncheckedException("Controller Advice works and throws unchecked Exception");
    }

    public void wrapMyCheckedException() throws MyExceptionWrapper {
        try {
            this.checked();
        } catch (MyCheckedException e) {
            throw new MyExceptionWrapper(e);
        }
    }
}
