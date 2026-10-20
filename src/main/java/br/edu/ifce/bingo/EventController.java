package br.edu.ifce.bingo;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import java.security.SecureRandom;

@RestController
@RequestMapping("/events")
@CrossOrigin("*")
public class EventController {

    private final NotifyEvents notifyEvents;

    public EventController(final NotifyEvents notifyEvents) {
        this.notifyEvents = notifyEvents;
    }

    @GetMapping(produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public SseEmitter events() {
        return notifyEvents.subscribe();
    }

    @GetMapping("random")
    public void send() {
        final var n = new SecureRandom().nextInt(75) + 1;
        notifyEvents.publish(n);
    }
}