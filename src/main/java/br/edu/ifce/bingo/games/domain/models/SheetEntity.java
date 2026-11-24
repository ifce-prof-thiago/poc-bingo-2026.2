package br.edu.ifce.bingo.games.domain.models;

import java.util.List;

public record SheetEntity(
        String hash,
        List<Integer> numbers
) {
}
