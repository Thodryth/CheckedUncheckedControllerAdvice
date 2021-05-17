package de.thodryth.runnableExcpetionTest.test.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import de.thodryth.runnableExcpetionTest.test.service.exceptions.MyCheckedException;
import de.thodryth.runnableExcpetionTest.test.service.exceptions.MyUncheckedException;

@Service
public class MyService {

    Logger logger = LoggerFactory.getLogger(MyService.class);

    public String checked(boolean bool) throws MyCheckedException {
        if (bool == true) {
            return "Nix geworfen";
        } else {
            logger.info("Else is called and checked will be throwen");
            throw new MyCheckedException("MyCheckedException");
        }
    }

    public String unchecked(boolean bool) {
        if (bool == true) {
            return "Nix geworfen";
        } else {
            logger.info("Else is called and unchecked will be throwen");
            throw new MyUncheckedException("MyUncheckedException");
        }
    }

}
