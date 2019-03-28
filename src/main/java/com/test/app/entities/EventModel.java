package com.test.app.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSetter;
import lombok.ToString;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.ResourceSupport;

import java.util.List;
import java.util.Map;

@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class EventModel extends ResourceSupport {

    private String eventId;
    private String entityType;
    private String entityId;
    private String type;
    private String entity;


    @JsonSetter("links")
    public void setLinks(List<LinkObject> links) {
        links.forEach(l -> add(convert(l)));
    }

    @JsonSetter("_links")
    public void set_Links(Map<String, Map<String, String>> links) {
        links.forEach((key, value) -> add(new Link(value.get("href"), key)));
    }

    public String getEventId() {
        return this.eventId;
    }

    public String getEntityType() {
        return this.entityType;
    }

    public String getEntityId() {
        return this.entityId;
    }


    public String getType() {
        return this.type;
    }

    public String getEntity() {
        return this.entity;
    }

    public EventModel setEventId(String eventId) {
        this.eventId = eventId;
        return this;
    }

    public EventModel setEntityType(String entityType) {
        this.entityType = entityType;
        return this;
    }

    public EventModel setEntityId(String entityId) {
        this.entityId = entityId;
        return this;
    }

    public EventModel setType(String type) {
        this.type = type;
        return this;
    }

    public EventModel setEntity(String entity) {
        this.entity = entity;
        return this;
    }

    private Link convert(LinkObject link) {
        return new Link(link.getHref(), link.getRel());
    }

}
