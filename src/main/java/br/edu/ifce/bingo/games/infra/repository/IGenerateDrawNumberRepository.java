package br.edu.ifce.bingo.games.infra.repository;

import br.edu.ifce.bingo.games.domain.models.GameEntity;

import java.util.Optional;

public interface IGenerateDrawNumberRepository {
    Optional<GameEntity> findGameByGameId(String gameId);
    void update(GameEntity game);
}
