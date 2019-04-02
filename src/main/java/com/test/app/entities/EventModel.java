package com.test.app.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.test.app.annotations.JsonRawObject;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.hateoas.ResourceSupport;

@EqualsAndHashCode(callSuper = true)
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class EventModel extends ResourceSupport {

    private String eventId;
    private String entityType;
    private String entityId;
    private String type;
    @JsonRawObject
    private String entity;

}
