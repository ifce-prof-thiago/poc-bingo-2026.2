package br.edu.ifce.bingo.games.domain.usecases.verify_wineer;

import java.util.List;

public interface IVerifyWinnerUseCase {

    boolean execute(String gameId, List<Integer> numbers);

}
