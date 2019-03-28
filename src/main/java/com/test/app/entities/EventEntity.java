package com.test.app.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "event")
public class EventEntity {

    @Id
    @Column(name = "eventId")
    private String eventId;
    @Column(name = "entityType")
    private String entityType;
    @Column(name = "entityId")
    private String entityId;
    @Column(name = "type")
    private String type;
    @Column(name = "entity")
    private String entity;

    public EventEntity() {
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

    public EventEntity setEventId(String eventId) {
        this.eventId = eventId;
        return this;
    }

    public EventEntity setEntityType(String entityType) {
        this.entityType = entityType;
        return this;
    }

    public EventEntity setEntityId(String entityId) {
        this.entityId = entityId;
        return this;
    }

    public EventEntity setType(String type) {
        this.type = type;
        return this;
    }

    public EventEntity setEntity(String entity) {
        this.entity = entity;
        return this;
    }

    public String toString() {
        return "EventEntity(eventId=" + this.getEventId() + ", entityType=" + this.getEntityType() + ", entityId=" + this.getEntityId() + ", type=" + this.getType() + ", entity=" + this.getEntity() + ")";
    }
}
