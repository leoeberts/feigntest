package com.example.feigntest;

import feign.Feign;
import feign.Logger;

class RemoteBoardsRepository {

    public static BoardRepository getRepositoryFrom(String uri) {
        return createClient(uri);
    }

    private static BoardRepository createClient(String uri) {
        return Feign.builder()
                .decoder(new GsonDecoder())
                .logger(new Logger.ErrorLogger())
                .logLevel(Logger.Level.BASIC)
                .target(BoardRepository.class, uri);
    }
}
