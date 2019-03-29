package com.test.app.controllers;

import com.test.app.entities.EventModel;
import com.test.app.services.EventsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("events")
public class EventsController {

    @Autowired
    private EventsService service;

    @GetMapping("{id}")
    public EventModel getEvent(@PathVariable("id") String id) {
        return service.getEvent(id);
    }

    @PostMapping
    public EventModel createEvent(@RequestBody String event) {
        return service.createEvent(event);
    }

    @PutMapping
    public EventModel updateEvent(@RequestBody String event) {
        return service.updateEvent(event);
    }

    @DeleteMapping("{id}")
    public void deleteEvent(@PathVariable("id") String id) {
        service.deleteEvent(id);
    }
}
