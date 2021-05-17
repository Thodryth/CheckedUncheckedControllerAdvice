package de.thodryth.runnableExcpetionTest.test.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import de.thodryth.runnableExcpetionTest.test.service.MyService;
import de.thodryth.runnableExcpetionTest.test.service.exceptions.MyCheckedException;

@RestController()
public class MyController {

    Logger logger = LoggerFactory.getLogger(MyController.class);

    @Autowired
    MyService myService;

    @GetMapping("/checked")
    public ResponseEntity<String> myCheckedException() throws MyCheckedException {
        String stuff = myService.checked(false);
        return new ResponseEntity<>(stuff, HttpStatus.OK);
    }

    @GetMapping("/unchecked")
    public ResponseEntity<String> myUncheckedException() {
        String stuff = myService.unchecked(false);
        return new ResponseEntity<>(stuff, HttpStatus.OK);
    }

    @GetMapping("/alive")
    public ResponseEntity<String> test() {
        return new ResponseEntity<>("The Service is alive", HttpStatus.OK);
    }

}
