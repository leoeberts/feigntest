package com.example.feigntest;

import org.springframework.stereotype.Service;

@Service
public class BoardRepositoryProvider {
    public BoardRepository getRepository(String url) {
        return RemoteBoardsRepository.getRepositoryFrom(url);
    }
}
