package com.test.app.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.test.app.annotations.DeserializeLinks;
import com.test.app.annotations.JsonRawObject;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.ResourceSupport;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class EventModel extends ResourceSupport {

    private String eventId;
    private String entityType;
    private String entityId;
    private String type;

    @JsonRawObject
    private String entity;

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


    @DeserializeLinks
    public void setLinks(List<Link> links) {
        add(links);
    }

    @Override
    public String toString() {
        return "EventModel{" +
                "eventId='" + eventId + '\'' +
                ", entityType='" + entityType + '\'' +
                ", entityId='" + entityId + '\'' +
                ", type='" + type + '\'' +
                ", entity='" + entity + '\'' +
                ", links='" + getLinks() + '\'' +
                '}';
    }
}
