package com.test.app.mapStruct;

import com.test.app.entities.EventEntity;
import com.test.app.entities.EventModel;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EventMapper {

    EventModel entityToModel(EventEntity entity);

    EventEntity modelToEntity(EventModel model);
}
