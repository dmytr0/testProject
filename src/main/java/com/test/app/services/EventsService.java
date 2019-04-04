package com.test.app.services;

import com.test.app.entities.EventEntity;
import com.test.app.exceptions.ValidationException;
import com.test.app.repository.EventRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EventsService {

    private final EventRepository repository;

    public EventsService(EventRepository repository) {
        this.repository = repository;
    }

    public EventEntity getEvent(String id) {
        Optional<EventEntity> eventEntity = repository.findById(id);
        return eventEntity.orElse(null);
    }

    public EventEntity createEvent(EventEntity event) {
        validate(event);
        return repository.save(event);
    }

    public void deleteEvent(String id) {
        repository.deleteById(id);
    }

    public EventEntity updateEvent(EventEntity event) {
        validate(event);
        return repository.save(event);
    }

    void validate(EventEntity entity) {
        if (isEmpty(entity.getEntity())) {
            throw new ValidationException("entity can't be empty");
        }
        if (isEmpty(entity.getEntityId())) {
            throw new ValidationException("entity id can't be empty");
        }
        if (isEmpty(entity.getEntityType())) {
            throw new ValidationException("entity type can't be empty");
        }
        if (isEmpty(entity.getEventId())) {
            throw new ValidationException("event id can't be empty");
        }
        if (isEmpty(entity.getType())) {
            throw new ValidationException("event type can't be empty");
        }
        if (isEmpty(entity.getLinks())) {
            throw new ValidationException("links can't be empty");
        }

    }

    private boolean isEmpty(String value) {
        return value == null || value.isEmpty();
    }
}
