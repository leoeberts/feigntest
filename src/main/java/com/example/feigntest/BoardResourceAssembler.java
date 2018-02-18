package com.example.feigntest;

import org.springframework.hateoas.mvc.ResourceAssemblerSupport;
import org.springframework.stereotype.Service;

@Service
public class BoardResourceAssembler extends ResourceAssemblerSupport<Board, BoardResource> {

    public BoardResourceAssembler() {
        super(Board.class, BoardResource.class);
    }

    @Override
    public BoardResource toResource(Board board) {
        return new BoardResource(board);
    }

    @Override
    protected BoardResource instantiateResource(Board board) {
        return new BoardResource(board);
    }
}