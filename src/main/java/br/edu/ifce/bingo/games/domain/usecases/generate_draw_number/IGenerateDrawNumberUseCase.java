package br.edu.ifce.bingo.games.domain.usecases.generate_draw_number;

public interface IGenerateDrawNumberUseCase {
    void execute(GenerateDrawNumberInput input);

    record GenerateDrawNumberInput(
            String gameId
    ) {
    }

}
