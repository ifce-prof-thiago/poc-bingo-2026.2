package br.edu.ifce.bingo.sheets.infra.gateways;

import br.edu.ifce.bingo.games.infra.repository.documents.GameDocument;
import br.edu.ifce.bingo.sheets.infra.repositories.IPersistSheetRepository;
import br.edu.ifce.bingo.sheets.infra.repositories.documents.SheetDocument;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

@Component
public class PersistSheetGateway implements IPersistSheetGateway {

    private final MongoTemplate database;

    public PersistSheetGateway(MongoTemplate database) {
        this.database = database;
    }

    @Override
    public boolean existsGameById(String gameId) {
        final var query = Query.query(Criteria.where("gameId").is(gameId));
        return !database.find(query, GameDocument.class).isEmpty();
    }

}
