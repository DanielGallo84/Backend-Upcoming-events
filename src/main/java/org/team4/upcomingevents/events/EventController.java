package org.team4.upcomingevents.events;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;

import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping(path = "${api-endpoint}/events")
public class EventController {

    EventService eventService;

    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @GetMapping(path = "")
    public List<Event> index() {
        List<Event> events = eventService.getAll();
        return events;
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Event> show(@NonNull @PathVariable("id") Long id) throws Exception {
        Event event = eventService.getById(id);
        return ResponseEntity.status(HttpStatusCode.valueOf(200)).body(event);
    }

    @PostMapping(path = "")
    public ResponseEntity<Event> store(@RequestBody EventDto eventDto) throws Exception {
        Event event = eventService.save(eventDto);
        return ResponseEntity.status(201).body(event);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Event> destroy(@PathVariable("id") Long id) throws Exception {
        Event deleted = eventService.delete(id);
        return ResponseEntity.accepted().body(deleted);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<Event> update(@PathVariable("id") Long id, @RequestBody EventDto eventDto) {
        Event event = eventService.update(eventDto, id);
        return  ResponseEntity.accepted().body(event);
    }

}
