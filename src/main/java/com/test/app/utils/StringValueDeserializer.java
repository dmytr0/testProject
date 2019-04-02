package com.test.app.utils;

import com.fasterxml.jackson.databind.util.StdConverter;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Log4j2
@Component
public class StringValueDeserializer extends StdConverter<Object, String> {


    @Override
    public String convert(Object o) {
        try {
            return JsonParser.prepareObjectJson(o);
        } catch (IOException e) {
            log.error("error parsing " + e.getMessage(), e);
        }
        return null;
    }


}