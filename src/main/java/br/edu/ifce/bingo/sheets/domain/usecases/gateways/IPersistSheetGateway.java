package br.edu.ifce.bingo.sheets.domain.usecases.gateways;

import java.util.List;

public interface IPersistSheetGateway {

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
