package br.edu.ifce.bingo.games.application.consumers;

import br.edu.ifce.bingo.games.domain.models.DrawNumberGenerated;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;

@Configuration
public class VerifyWinnerWhenANumberIsGenerated {

    @EventListener
    public void execute(DrawNumberGenerated event) {
        System.out.println(">>> Verify Winner: " + event);
    }
}
