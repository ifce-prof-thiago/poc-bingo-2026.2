package br.edu.ifce.bingo.games.domain.usecases.verify_wineer;

import br.edu.ifce.bingo.games.domain.models.SheetEntity;
import br.edu.ifce.bingo.games.infra.repository.IVerifyWinnerRepository;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Map;

@Component
public class VerifyWinnerUseCase implements IVerifyWinnerUseCase {

    private final IVerifyWinnerRepository verifyWinnerRepository;

    public VerifyWinnerUseCase(IVerifyWinnerRepository verifyWinnerRepository) {
        this.verifyWinnerRepository = verifyWinnerRepository;
    }

    @Transactional
    @Override
    public void execute(String gameId, Map<Integer, Boolean> numbers) {
        if (numbers.size() < 24) {
            return;
        }
        final var sheets = verifyWinnerRepository.findSheetByGameId(gameId);
        final var listWinnerSheets = new ArrayList<String>();
        for (var sheet : sheets) {
            boolean winner = true;
            for (var n : sheet.numbers()) {
                if (!numbers.containsKey(n)) {
                    winner = false;
                    break;
                }
            }
            if (winner) {
                listWinnerSheets.add(sheet.hash());
            }
        }
        if (!listWinnerSheets.isEmpty()) {
            verifyWinnerRepository.updateGameByIdToWinnerTrue(gameId);
            verifyWinnerRepository.updateSheetsToWinnerTrue(listWinnerSheets);
        }
    }

}
