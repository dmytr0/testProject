package com.test.app.utils;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import org.springframework.hateoas.Link;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class LinksDeserializer extends StdDeserializer<List<Link>> {

    public LinksDeserializer() {
        this(null);
    }

    public LinksDeserializer(Class<?> vc) {
        super(vc);
    }


    @Override
    public List<Link> deserialize(JsonParser p, DeserializationContext ctx) throws IOException, JsonProcessingException {
        JsonToken token = p.getCurrentToken();

        List<Link> result = new ArrayList<>();

        if (token == JsonToken.START_OBJECT) {
            Map<String, Map<String, String>> map = ctx.readValue(p, Map.class);
            for (Map.Entry<String, Map<String, String>> entry : map.entrySet()) {
                Map<String, String> values = entry.getValue();
                Link link = getLink(entry.getKey(), values);
                result.add(link);
            }

        } else if (token == JsonToken.START_ARRAY) {
            List<Map<String, String>> list = ctx.readValue(p, List.class);
            for (Map<String, String> values : list) {
                Link link = getLink(values.get("rel"), values);
                result.add(link);
            }
        }
        return result;
    }

    private Link getLink(String rel, Map<String, String> values) {
        Link link = new Link(values.get("href"), rel);
        link.withHreflang(values.get("hreflang"));
        link.withMedia(values.get("media"));
        link.withTitle(values.get("title"));
        link.withType(values.get("type"));
        link.withDeprecation(values.get("deprecation"));
        return link;
    }
}
