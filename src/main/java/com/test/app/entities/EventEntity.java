package com.test.app.entities;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity(name = "EVENT")
public class EventEntity {

    @Id
    @Column(name = "EVENT_ID")
    private String eventId;
    @Column(name = "ENTITY_TYPE")
    private String entityType;
    @Column(name = "ENTITY_ID")
    private String entityId;
    @Column(name = "TYPE")
    private String type;
    @Column(name = "ENTITY", length = 2000, columnDefinition = "text")
    private String entity;
    @Column(name = "_LINKS", length = 2000, columnDefinition = "text")
    private String links;

}
