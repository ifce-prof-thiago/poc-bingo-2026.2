package br.edu.ifce.bingo.games.infra.repository;

import br.edu.ifce.bingo.games.domain.models.SheetEntity;

import java.util.List;

public interface IVerifyWinnerRepository {

    List<SheetEntity> findSheetByGameId(String gameId);
    void updateGameByIdToWinnerTrue(String gameId);
    void updateSheetsToWinnerTrue(List<String> hashes);

}
