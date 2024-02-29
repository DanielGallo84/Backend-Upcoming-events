package org.team4.upcomingevents.events;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.jupiter.api.Test;

public class EventTest {

    @Test
    void testEventProperties() {
        Event event = Event.builder()
                .id(1L)
                .title("Rock")
                .date("01/01/1999")
                .hour("08:30")
                .place("Madrid")
                .description("foo")
                .capacity(0)
                .isOutstanding(false)
                .img("image.jpg")
                .build();

        assertThat(event.getClass().getDeclaredFields().length, is(10));
        assertThat(event.getId(), is(1L));
        assertThat(event.getTitle(), is("Rock"));
        assertThat(event.getDate(), is("01/01/1999"));
        assertThat(event.getHour(), is("08:30"));
        assertThat(event.getPlace(), is("Madrid"));
        assertThat(event.getDescription(), is("foo"));
        assertThat(event.getCapacity(), is(0));
        assertThat(event.isOutstanding(), is(false));
        assertThat(event.getImg(), is("image.jpg"));

    }

}
