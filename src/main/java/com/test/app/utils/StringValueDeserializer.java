package com.test.app.utils;

import com.fasterxml.jackson.databind.util.StdConverter;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class StringValueDeserializer extends StdConverter<Object, String> {


    @Override
    public String convert(Object o) {
        try {
            return JsonParser.prepareObjectJson(o);
        } catch (IOException e) {
            //handle error
            e.printStackTrace();
        }
        return null;
    }


}