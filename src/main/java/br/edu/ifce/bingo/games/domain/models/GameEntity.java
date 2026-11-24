package br.edu.ifce.bingo.games.domain.models;

import java.util.Map;

public record GameEntity(
        String gameId,
        Map<Integer, Boolean> numbers,
        Boolean hasWinner
) {
}
