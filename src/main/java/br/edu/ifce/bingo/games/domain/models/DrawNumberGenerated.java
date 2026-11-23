package br.edu.ifce.bingo.games.domain.models;

import java.time.Instant;
import java.util.List;

public record DrawNumberGenerated(
        Instant occurredIn,
        String gameId,
        List<Integer> numbers
) {
}
