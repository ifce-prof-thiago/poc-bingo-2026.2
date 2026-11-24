package br.edu.ifce.bingo.games.domain.models;

import java.time.Instant;
import java.util.List;
import java.util.Map;

public record DrawNumberGenerated(
        Instant occurredIn,
        String gameId,
        Map<Integer, Boolean> numbers
) {
}
