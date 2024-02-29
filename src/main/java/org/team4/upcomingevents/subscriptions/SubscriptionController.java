package org.team4.upcomingevents.subscriptions;

import java.util.HashMap;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.team4.upcomingevents.generics.IGenericSubscription;
import org.team4.upcomingevents.responses.Response;

@RestController
@RequestMapping(path = "${api-endpoint}")
public class SubscriptionController {

    IGenericSubscription service;

    public SubscriptionController(IGenericSubscription service) {
        this.service = service;
    }

    @GetMapping(path = "/events/{id}/subscription")
    public ResponseEntity<HashMap<String, String>> subscribe(@PathVariable Long id) throws Exception {

        boolean isSubscribed = service.subscribe(id);

        if (isSubscribed) {
            return ResponseEntity.ok().body(Response.getResponse("Subscription successfully"));
        }

        return ResponseEntity.status(406).body(Response.getResponse("Subscription not possible"));
    }

}
