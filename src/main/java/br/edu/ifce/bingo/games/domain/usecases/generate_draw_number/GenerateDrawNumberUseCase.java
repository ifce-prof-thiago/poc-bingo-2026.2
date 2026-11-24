package br.edu.ifce.bingo.games.domain.usecases.generate_draw_number;

import br.edu.ifce.bingo.games.domain.models.DrawNumberGenerated;
import br.edu.ifce.bingo.games.infra.repository.IGenerateDrawNumberRepository;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

import java.security.SecureRandom;
import java.time.Instant;

@Component
public class GenerateDrawNumberUseCase implements IGenerateDrawNumberUseCase {

    private final ApplicationEventPublisher publisher;
    private final IGenerateDrawNumberRepository generateDrawNumberRepository;

    public GenerateDrawNumberUseCase(
            ApplicationEventPublisher publisher,
            IGenerateDrawNumberRepository generateDrawNumberRepository
    ) {
        this.publisher = publisher;
        this.generateDrawNumberRepository = generateDrawNumberRepository;
    }

    @Override
    public void execute(GenerateDrawNumberInput input) {
        final var gameId = input.gameId();
        final var game = generateDrawNumberRepository
                .findGameByGameId(gameId)
                .orElseThrow(() -> new RuntimeException("O jogo com id 'id': %s não existe!".formatted(gameId)));
        if (game.hasWinner()) {
            throw new RuntimeException("Este jogo já foi finalizado!");
        }
        var number = 0;
        do {
            number = new SecureRandom().nextInt(75) + 1;
        } while (game.numbers().containsKey(number));
        game.numbers().put(number, true);
        generateDrawNumberRepository.update(game);
        publisher.publishEvent(
                new DrawNumberGenerated(
                        Instant.now(),
                        gameId,
                        game.numbers()
                )
        );
    }

}
