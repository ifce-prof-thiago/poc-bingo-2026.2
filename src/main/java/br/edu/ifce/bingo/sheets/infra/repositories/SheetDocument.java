package br.edu.ifce.bingo.sheets.infra.repositories;

import java.util.List;

public record SheetDocument(
        String id,
        String gameId,
        List<Integer> listB,
        List<Integer> listI,
        List<Integer> listN,
        List<Integer> listG,
        List<Integer> listO,
        String hash
) {
}
