package com.test.app.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.test.app.annotations.JsonRawObject;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@EqualsAndHashCode(callSuper = true)
@Getter
@Setter
@ToString(callSuper = true)
@JsonIgnoreProperties(ignoreUnknown = true)
public class EventModel extends CustomResourceSupport {

    private String eventId;
    private String entityType;
    private String entityId;
    private String type;
    @JsonRawObject
    private String entity;

}
