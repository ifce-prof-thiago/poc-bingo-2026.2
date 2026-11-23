package br.edu.ifce.bingo.games.domain.usecases.create;

public interface ICreateGameUseCase {
    CreateGameOutput execute();

    record CreateGameOutput(
            String gameId
    ) {
    }
}
