package br.edu.ifce.bingo.sheets.infra.repositories;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document("sheets")
public record SheetDocument(
        @Id String id,
        String gameId,
        List<Integer> listB,
        List<Integer> listI,
        List<Integer> listN,
        List<Integer> listG,
        List<Integer> listO,
        String hash
) {
}
