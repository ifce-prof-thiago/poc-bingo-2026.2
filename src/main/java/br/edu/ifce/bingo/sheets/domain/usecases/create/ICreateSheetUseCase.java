package br.edu.ifce.bingo.sheets.domain.usecases.create;

import java.util.List;

public interface ICreateSheetUseCase {

    CreateSheetOutput execute(CreateSheetInput input);

    record CreateSheetInput(String gameId) {
    }

    record CreateSheetOutput(
            List<Integer> listB,
            List<Integer> listI,
            List<Integer> listN,
            List<Integer> listG,
            List<Integer> listO,
            String hash
    ) {
    }

}
