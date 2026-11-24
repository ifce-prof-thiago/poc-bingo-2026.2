package br.edu.ifce.bingo.games.domain.usecases.verify_wineer;

import java.util.Map;

public interface IVerifyWinnerUseCase {

    void execute(String gameId, Map<Integer, Boolean> numbers);

}
