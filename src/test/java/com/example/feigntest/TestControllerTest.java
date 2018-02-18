package com.example.feigntest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class TestControllerTest {

    @Autowired
    TestController testController;
    @Autowired
    private TestService service;

    @Test
    public void teste() {
        System.out.println("Remoto: ");
        System.out.println(service.getAll("https://task-boards-board-service.herokuapp.com/boards"));

        System.out.println("Local: ");
        service.create("http://localhost:8080/boards");
        System.out.println("Número de chamadas: " + testController.chamadas);
    }
}