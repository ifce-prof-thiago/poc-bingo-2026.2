package br.edu.ifce.bingo.games.infra.repository;

import br.edu.ifce.bingo.games.domain.models.GameEntity;
import br.edu.ifce.bingo.games.infra.repository.documents.GameDocument;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class GenerateGameDrawRepository implements IGenerateDrawNumberRepository {

    private final MongoTemplate database;

    public GenerateGameDrawRepository(MongoTemplate database) {
        this.database = database;
    }

    @Override
    public Optional<GameEntity> findGameByGameId(String gameId) {
        final var query = Query.query(Criteria.where("gameId").is(gameId));
        final var document = database.findOne(query, GameDocument.class);

        if (document == null) {
            return Optional.empty();
        }

        final var game = new GameEntity(
                document.gameId(),
                document.numbers(),
                document.hasWinner()
        );
        return Optional.of(game);
    }

    @Override
    public void update(GameEntity game) {
        final var query = Query.query(Criteria.where("gameId").is(game.gameId()));
        final var update = new Update().set("numbers", game.numbers());
        database.updateFirst(query, update, GameDocument.class);
    }
}
