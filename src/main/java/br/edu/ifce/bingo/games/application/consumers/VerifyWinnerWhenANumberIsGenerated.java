package br.edu.ifce.bingo.games.application.consumers;

import br.edu.ifce.bingo.games.domain.models.DrawNumberGenerated;
import br.edu.ifce.bingo.games.domain.usecases.verify_wineer.IVerifyWinnerUseCase;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;

@Configuration
public class VerifyWinnerWhenANumberIsGenerated {

    private final IVerifyWinnerUseCase verifyWinnerUseCase;

    public VerifyWinnerWhenANumberIsGenerated(IVerifyWinnerUseCase verifyWinnerUseCase) {
        this.verifyWinnerUseCase = verifyWinnerUseCase;
    }

    @EventListener
    public void execute(DrawNumberGenerated event) {
        verifyWinnerUseCase.execute(
                event.gameId(),
                event.numbers()
        );
    }
}
