package br.edu.ifce.bingo.games.domain.usecases.generate_draw_number;

import br.edu.ifce.bingo.games.domain.models.DrawNumberGenerated;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

import java.security.SecureRandom;
import java.time.Instant;
import java.util.List;

@Component
public class GenerateDrawNumberUseCase implements IGenerateDrawNumberUseCase {

    private final ApplicationEventPublisher publisher;

    public GenerateDrawNumberUseCase(ApplicationEventPublisher publisher) {
        this.publisher = publisher;
    }

    @Override
    public int execute(String gameId) {
        var list = new java.util.ArrayList<>(List.of(6, 37, 40));
        var number = 0;
        do {
            number = new SecureRandom().nextInt(75) + 1;
            list.add(number);
        } while (!list.contains(number));
        final var event = new DrawNumberGenerated(
                Instant.now(),
                gameId,
                list
        );
        publisher.publishEvent(event);
        return number;
    }

}
