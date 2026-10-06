package br.edu.ifce.bingo;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

@RestController
@RequestMapping("/events")
public class EventController {

    private final NotifyEvents notifyEvents;

    public EventController(final NotifyEvents notifyEvents) {
        this.notifyEvents = notifyEvents;
    }

    @GetMapping(produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public SseEmitter events() {
        return notifyEvents.subscribe();
    }

    @PostMapping
    public void send(@RequestBody final Input input) {
        notifyEvents.publish(input.n());
    }

    public record Input(int n) { }
}