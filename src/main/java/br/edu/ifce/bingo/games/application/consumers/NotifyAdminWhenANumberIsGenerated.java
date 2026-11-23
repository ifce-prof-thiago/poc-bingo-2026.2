package br.edu.ifce.bingo.games.application.consumers;

import br.edu.ifce.bingo.games.domain.models.DrawNumberGenerated;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;

@Configuration
public class NotifyAdminWhenANumberIsGenerated {

    @EventListener
    public void execute(DrawNumberGenerated event) {
        System.out.println(">>> Notify event: " + event);
    }

}
