package br.edu.ifce.bingo.games.application.controllers;

import br.edu.ifce.bingo.games.domain.usecases.create.ICreateGameUseCase;
import br.edu.ifce.bingo.games.domain.usecases.generate_draw_number.IGenerateDrawNumberUseCase;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/v1/games")
@RestController
public class GameController {

    private final IGenerateDrawNumberUseCase generateDrawNumberUseCase;
    private final ICreateGameUseCase createGameUseCase;

    public GameController(
            IGenerateDrawNumberUseCase generateDrawNumberUseCase,
            ICreateGameUseCase createGameUseCase
    ) {
        this.generateDrawNumberUseCase = generateDrawNumberUseCase;
        this.createGameUseCase = createGameUseCase;
    }

    @PostMapping
    public ICreateGameUseCase.CreateGameOutput create() {
        return createGameUseCase.execute();
    }

    @PatchMapping
    public void generate(@RequestBody IGenerateDrawNumberUseCase.GenerateDrawNumberInput input) {
        generateDrawNumberUseCase.execute(input);
    }
}
