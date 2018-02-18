package com.example.feigntest;

import org.springframework.hateoas.Resource;

public class BoardResource extends Resource<Board> {

    public BoardResource(Board board) {
        super(board);
    }
}
