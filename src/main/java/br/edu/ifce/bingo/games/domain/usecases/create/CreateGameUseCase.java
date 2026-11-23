package br.edu.ifce.bingo.games.domain.usecases.create;

import br.edu.ifce.bingo.games.infra.repository.ICreateGameRepository;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class CreateGameUseCase implements ICreateGameUseCase {

    private final ICreateGameRepository createGameRepository;

    public CreateGameUseCase(ICreateGameRepository createGameRepository) {
        this.createGameRepository = createGameRepository;
    }

    @Override
    public CreateGameOutput execute() {
        final var gameId = UUID.randomUUID().toString();
        createGameRepository.save(gameId);
        return new CreateGameOutput(
                gameId
        );
    }

}
