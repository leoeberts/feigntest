package com.example.feigntest;

import feign.RequestLine;
import org.springframework.cloud.netflix.feign.FeignClient;

import java.util.List;

@FeignClient
public interface BoardRepository {

    @RequestLine("GET")
    List<BoardResource> findAll();

    @RequestLine("POST")
    void create();
}
