package com.test.app.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.test.app.controllers.EventsController;
import com.test.app.entities.EventEntity;
import com.test.app.entities.EventModel;
import com.test.app.mapStruct.EventMapper;
import com.test.app.repository.EventRepository;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Optional;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;

@Service
public class EventsService {

    private static final Logger log = org.apache.logging.log4j.LogManager.getLogger(EventsService.class);

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private EventRepository repository;

    @Autowired
    private EventMapper mapper;

    public EventModel getEvent(String id) {
        Optional<EventEntity> eventEntity = repository.findById(id);
        return eventEntity.map(this::convert).orElse(null);
    }

    public EventModel createEvent(String event) {
        EventModel model = parseEvent(event);
        System.out.println(model.getLinks());
        EventEntity eventEntity = mapper.modelToEntity(model);
        EventEntity entity = repository.save(eventEntity);
        return convert(entity);
    }

    public void deleteEvent(String id) {
        repository.deleteById(id);
    }

    public EventModel updateEvent(String event) {
        EventEntity eventEntity = mapper.modelToEntity(parseEvent(event));
        EventEntity entity = repository.save(eventEntity);
        return convert(entity);
    }

    private EventModel convert(EventEntity entity) {
        EventModel event = mapper.entityToModel(entity);
        Link self = linkTo(EventsController.class).slash(event.getEventId()).withSelfRel();
        event.add(self);
        return event;
    }

    private EventModel parseEvent(String json) {
        EventModel eventModel = null;
        try {
            eventModel = objectMapper.readValue(json, EventModel.class);
        } catch (IOException e) {
            log.error("Error parsing");
        }
        return eventModel;
    }
}
