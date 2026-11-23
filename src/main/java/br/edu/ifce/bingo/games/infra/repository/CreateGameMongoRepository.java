package br.edu.ifce.bingo.games.infra.repository;

import br.edu.ifce.bingo.games.infra.repository.documents.GameDocument;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

import java.util.HashMap;

@Component
public class CreateGameMongoRepository implements ICreateGameRepository {

    private final MongoTemplate database;

    public CreateGameMongoRepository(MongoTemplate database) {
        this.database = database;
    }

    @Override
    public void save(String gameId) {
        final var game = new GameDocument(
                null,
                gameId,
                new HashMap<>(),
                false
        );
        database.insert(game);
    }

}
