package org.team4.upcomingevents.users;

import java.util.Collection;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.team4.upcomingevents.events.Event;

@RestController
@RequestMapping(path = "${api-endpoint}/users")
public class UserController {

    UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @GetMapping(path = "/events")
    public ResponseEntity<Collection<Event>> getEvents() {
        Collection<Event> events = service.get();
        return ResponseEntity.ok().body(events);
    }

}
