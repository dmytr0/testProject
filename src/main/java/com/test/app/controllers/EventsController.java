package com.test.app.controllers;

import com.test.app.entities.EventModel;
import com.test.app.exceptions.ValidationException;
import com.test.app.mapStruct.EventMapper;
import com.test.app.services.EventsService;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Log4j2
@RestController
@RequestMapping("events")
public class EventsController {

    private final EventsService service;
    private final EventMapper mapper;

    public EventsController(EventsService service, EventMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @GetMapping("{id}")
    public EventModel getEvent(@PathVariable("id") String id) {
        log.info("get request " + id);
        return mapper.entityToModel(service.getEvent(id));
    }

    @PostMapping
    public EventModel createEvent(@RequestBody EventModel event) {
        log.info("create event " + event);
        return mapper.entityToModel(service.createEvent(mapper.modelToEntity(event)));
    }

    @PutMapping("{id}")
    public EventModel updateEvent(@PathVariable("id") String id, @RequestBody EventModel event) {
        log.info("update request " + event);
        event.setEventId(id);
        return mapper.entityToModel(service.updateEvent(mapper.modelToEntity(event)));
    }

    @DeleteMapping("{id}")
    public void deleteEvent(@PathVariable("id") String id) {
        log.info("delete " + id);
        service.deleteEvent(id);
    }

    @ExceptionHandler(ValidationException.class)
    public ResponseEntity<String> handleValidationException(ValidationException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }
}
