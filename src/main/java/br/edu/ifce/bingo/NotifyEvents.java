package br.edu.ifce.bingo;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import java.io.IOException;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class NotifyEvents {

    private final Set<SseEmitter> emitters = ConcurrentHashMap.newKeySet();

    public SseEmitter subscribe() {
        final var emitter = new SseEmitter(0L);
        emitters.add(emitter);
        emitter.onCompletion(() -> emitters.remove(emitter));
        emitter.onError((e) -> emitters.remove(emitter));
        emitter.onTimeout(() -> emitters.remove(emitter));
        return emitter;
    }

    public void publish(final int number) {
        for (final var emitter : emitters) {
            final var event = SseEmitter
                    .event()
                    .name("sorted-number")
                    .data(number);
            try {
                emitter.send(event);
            } catch (IOException e) {
                emitter.completeWithError(e);
            }
        }
    }

}
