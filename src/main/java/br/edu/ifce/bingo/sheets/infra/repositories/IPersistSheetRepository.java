package br.edu.ifce.bingo.sheets.infra.repositories;

import java.util.List;

public interface IPersistSheetRepository {

    void insert(PersistSheet persistSheet);

    boolean existsByHash(String hash);

    record PersistSheet(
            String gameId,
            List<Integer> listB,
            List<Integer> listI,
            List<Integer> listN,
            List<Integer> listG,
            List<Integer> listO,
            String hash
    ) {
    }
}
