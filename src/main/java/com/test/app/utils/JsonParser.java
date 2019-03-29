package com.test.app.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;

import java.io.IOException;
import java.util.List;

public class JsonParser {

    private static final ObjectMapper mapperJson = new ObjectMapper();

    public static String prepareObjectJson(Object o) throws IOException {
        return mapperJson.writeValueAsString(o);
    }

    public static <T> T parseObjectJson(String obj, Class<T> c) throws IOException {
        return mapperJson.readValue(obj, c);
    }

    public static <T> List<T> parseListJson(String obj, Class<T> c) throws IOException {
        TypeFactory typeFactory = mapperJson.getTypeFactory();
        return mapperJson.readValue(obj, typeFactory.constructCollectionType(List.class, c));
    }
}
