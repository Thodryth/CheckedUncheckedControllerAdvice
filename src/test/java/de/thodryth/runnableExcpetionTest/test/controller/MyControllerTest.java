package de.thodryth.runnableExcpetionTest.test.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import de.thodryth.runnableExcpetionTest.test.service.MyService;
import de.thodryth.runnableExcpetionTest.test.service.exceptions.MyCheckedException;
import de.thodryth.runnableExcpetionTest.test.service.exceptions.MyUncheckedException;

import static org.mockito.Mockito.doThrow;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@WebMvcTest(value = MyController.class)
public class MyControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    MyService myService;

    @Test
    @DisplayName("calling /alive should return message")
    void callAliveSuccessful() throws Exception {
        String expected = "The Service is alive";
        mockMvc.perform(get("/alive")).andExpect(status().isOk()).andExpect(content().string(expected));
    }

    @Test
    @DisplayName("calling /unchecked should throw my unchecked exception")
    void throwUncheckedWhenCallUnchecked() throws Exception {
        doThrow(new MyUncheckedException("Test")).when(myService).unchecked();
        mockMvc.perform(get("/unchecked")).andExpect(status().isOk());
    }

    @Test
    @DisplayName("calling /checked should throw my checked exception")
    void throwCheckedWhenCallChecked() throws Exception {
        doThrow(new MyCheckedException("Test")).when(myService).checked();
        mockMvc.perform(get("/checked")).andExpect(status().isAccepted());
    }

}
