package com.example.feigntest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestService {

    @Autowired
    private BoardResourceAssembler assembler;

    @Autowired
    private BoardRepositoryProvider repositoryProvider;


    public ResponseEntity<List<BoardResource>> getAll(String url) {
        List<BoardResource> boards = repositoryProvider.getRepository(url).findAll();
        if (boards.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(boards, HttpStatus.OK);
    }

    public void create(String url) {
        repositoryProvider.getRepository(url).create();
    }
}
