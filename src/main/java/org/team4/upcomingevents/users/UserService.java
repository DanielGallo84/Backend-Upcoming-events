package org.team4.upcomingevents.users;

import java.util.Collection;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.team4.upcomingevents.events.Event;

@Service
public class UserService {

    UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public Collection<Event> get() {

        SecurityContext contextHolder = SecurityContextHolder.getContext();
        Authentication auth = contextHolder.getAuthentication();
        User user = repository.findByUsername(auth.getName())
                .orElseThrow(() -> new UserNotFoundException("User does not exist"));

        return user.getEvents();
    }

}
