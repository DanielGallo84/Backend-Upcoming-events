package org.team4.upcomingevents.events;

import java.util.List;

import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;
import org.team4.upcomingevents.generics.IGenericEditService;
import org.team4.upcomingevents.generics.IGenericGetService;

@Service
public class EventService implements IGenericGetService<Event>,IGenericEditService<EventDto,Event> {

    EventRepository repository;

    public EventService(EventRepository eventRepository) {
        this.repository = eventRepository;
    }

    public List<Event> getAll() {
        List<Event> events = repository.findAll();
        return events;

    }

    public Event getById(@NonNull Long id) throws Exception {

        Event event = repository.findById(id).orElseThrow(() -> new EventNotFoundException("Event not found"));
        return event;
    }

    public Event save(EventDto eventDto) throws Exception {
        
        try {
            Event newEvent = Event.builder()
                                .title(eventDto.getTitle())
                                .date(eventDto.getDate())
                                .hour(eventDto.getHour())
                                .place(eventDto.getPlace())
                                .description(eventDto.getDescription())
                                .capacity(eventDto.getCapacity())
                                .isOutstanding(eventDto.isOutstanding())
                                .build();
            repository.save(newEvent);

            Long eventsTableQuantity = (long) repository.findAll().size();
            Event event = repository.findById(eventsTableQuantity).orElseThrow( () -> new EventNotFoundException("Event not found"));
            return event;
        } catch (Exception e) {
            throw new Exception("Error al guardar en base de datos" + e.getMessage());
        }

    }

    public Event delete(Long id) throws Exception {
        Event eventToDelete = repository.findById(id).orElseThrow( () -> new EventNotFoundException("Event does not exit"));
        repository.deleteById(id);
        return eventToDelete;
    }

    @Override
    public Event update(EventDto eventDto, Long id) {
        Event event = repository.findById(id).orElseThrow( () -> new EventNotFoundException("Event does not exist"));

        event.setTitle(eventDto.getTitle());
        event.setDate(eventDto.getDate());
        event.setHour(eventDto.getHour());
        event.setPlace(eventDto.getPlace());
        event.setDescription(eventDto.getDescription());

        return repository.save(event);
    }
}
