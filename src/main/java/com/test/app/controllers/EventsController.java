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

    @GetMapping("get/{id}")
    public EventModel getEvent(@PathVariable("id") String id) {
        return service.getEvent(id);
    }

    @PostMapping("create")
    public EventModel createEvent(@RequestBody String event) {
        return service.createEvent(event);
    }

    @PutMapping("update")
    public EventModel updateEvent(@RequestBody String event) {
        return service.updateEvent(event);
    }

    @DeleteMapping("delete/{id}")
    public void deleteEvent(@PathVariable("id") String id) {
        service.deleteEvent(id);
    }
}
