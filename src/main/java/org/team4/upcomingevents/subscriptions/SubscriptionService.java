package org.team4.upcomingevents.subscriptions;

import java.util.Collection;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.team4.upcomingevents.events.Event;
import org.team4.upcomingevents.events.EventService;
import org.team4.upcomingevents.generics.IGenericSubscription;
import org.team4.upcomingevents.users.User;
import org.team4.upcomingevents.users.UserNotFoundException;
import org.team4.upcomingevents.users.UserRepository;

@Service
public class SubscriptionService implements IGenericSubscription {

    EventService eventService;
    UserRepository userRepository;

    public SubscriptionService(EventService eventService, UserRepository userRepository) {
        this.eventService = eventService;
        this.userRepository = userRepository;
    }

    public boolean subscribe(Long eventId) throws Exception {

        // recuperar el evento
        Event event = eventService.getById(eventId);
        
        // recuperar el usuario
        SecurityContext contextHolder = SecurityContextHolder.getContext();
        Authentication auth = contextHolder.getAuthentication();
        User user = userRepository.findByUsername(auth.getName())
                .orElseThrow(() -> new UserNotFoundException("User does not exist"));
        
        // descontamos 1 de capacidad
        if (event.getCapacity() != 0) {
            // asignar el evento al usuario
            Collection<Event> events = user.getEvents();
            events.add(event);
            user.setEvents(events);
            userRepository.save(user);
            event.setCapacity(event.getCapacity() - 1);
            return true;
        }

        return false;
    }

}
