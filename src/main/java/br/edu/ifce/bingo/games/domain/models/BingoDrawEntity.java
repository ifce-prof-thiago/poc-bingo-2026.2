package br.edu.ifce.bingo.games.domain.models;

import java.util.List;

public record BingoDrawEntity(
        String gameId,
        List<Integer> numbers
) {
}
