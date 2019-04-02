package com.test.app.mapStruct;

import com.test.app.entities.EventEntity;
import com.test.app.entities.EventModel;
import com.test.app.utils.JsonParser;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.springframework.hateoas.Link;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

@Mapper(componentModel = "spring")
public interface EventMapper {


    @Mapping(source = "links", target = "links", qualifiedByName = "stringToLinks")
    EventModel entityToModel(EventEntity entity);

    @Mapping(source = "links", target = "links", qualifiedByName = "linksToString")
    EventEntity modelToEntity(EventModel model);

    @Named("linksToString")
    default String linksToString(List<Link> links) throws IOException {
        if (links == null || links.isEmpty()) {
            return null;
        }
        return JsonParser.prepareObjectJson(links);
    }

    @Named("stringToLinks")
    default List<Link> stringToLinks(String links) throws IOException {
        if (links == null || links.isEmpty()) {
            return Collections.emptyList();
        }
        return JsonParser.parseListJson(links, Link.class);
    }
}
