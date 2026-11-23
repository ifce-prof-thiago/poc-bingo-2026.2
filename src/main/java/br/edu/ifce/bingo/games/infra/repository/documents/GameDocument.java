package br.edu.ifce.bingo.games.infra.repository.documents;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Map;

@Document("games")
public record GameDocument(
        @Id String id,
        String gameId,
        Map<Integer, Boolean> numbers,
        Boolean hasWinner
) {
}
