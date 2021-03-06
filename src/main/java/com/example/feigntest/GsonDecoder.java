package com.example.feigntest;

import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import feign.Response;
import feign.codec.Decoder;

import java.io.IOException;
import java.lang.reflect.Type;

public class GsonDecoder implements Decoder {
    private final Gson gson = new Gson();

    @Override
    public Object decode(Response response, Type type) throws IOException {
        try {
            return gson.fromJson(response.body().asReader(), type);
        } catch (JsonIOException e) {
            if (e.getCause() != null &&
                    e.getCause() instanceof IOException) {
                throw IOException.class.cast(e.getCause());
            }
            throw e;
        }
    }
}