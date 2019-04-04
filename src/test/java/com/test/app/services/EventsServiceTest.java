package com.test.app.services;

import com.test.app.entities.EventEntity;
import com.test.app.exceptions.ValidationException;
import com.test.app.repository.EventRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Random;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;


@RunWith(MockitoJUnitRunner.class)
public class EventsServiceTest {

    @Spy
    @InjectMocks
    private EventsService service;

    @Mock
    private EventRepository repository;

    @Test
    public void getEvent() {
        String id = randomString();

        service.getEvent(id);

        verify(repository, times(1)).findById(eq(id));
        verifyNoMoreInteractions(repository);
    }


    @Test
    public void createEvent() {
        EventEntity eventEntity = mock(EventEntity.class);
        doNothing().when(service).validate(any());

        service.createEvent(eventEntity);

        verify(repository, times(1)).save(eq(eventEntity));
        verify(service, times(1)).validate(eq(eventEntity));
    }

    @Test
    public void deleteEvent() {
        String id = randomString();

        service.deleteEvent(id);

        verify(repository, times(1)).deleteById(eq(id));
        verifyNoMoreInteractions(repository);
    }

    @Test
    public void updateEvent() {
        EventEntity eventEntity = mock(EventEntity.class);
        doNothing().when(service).validate(any());

        service.updateEvent(eventEntity);

        verify(repository, times(1)).save(eq(eventEntity));
        verify(service, times(1)).validate(eq(eventEntity));
    }

    @Test
    public void validate() {
        EventEntity mock = mock(EventEntity.class);
        when(mock.getEntity()).thenReturn(randomString());
        when(mock.getEntityId()).thenReturn(randomString());
        when(mock.getEntityType()).thenReturn(randomString());
        when(mock.getEventId()).thenReturn(randomString());
        when(mock.getType()).thenReturn(randomString());
        when(mock.getLinks()).thenReturn(randomString());

        service.validate(mock);
    }

    @Test(expected = ValidationException.class)
    public void validateFailedAbsentEntity() {
        EventEntity mock = mock(EventEntity.class);

        service.validate(mock);
    }

    private String randomString() {
        return String.valueOf(new Random().nextLong());
    }
}
