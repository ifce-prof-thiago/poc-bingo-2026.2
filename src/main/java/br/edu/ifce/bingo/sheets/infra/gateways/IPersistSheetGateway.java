package br.edu.ifce.bingo.sheets.infra.gateways;

public interface IPersistSheetGateway {
    boolean existsGameById(String gameId);
}
