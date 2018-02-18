package com.example.feigntest;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/boards")
public class TestController {

    public int chamadas;
    BoardResourceAssembler assembler = new BoardResourceAssembler();

    @PostMapping
    public void create() {
        this.chamadas++;
    }
}