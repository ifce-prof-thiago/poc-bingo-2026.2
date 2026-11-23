package br.edu.ifce.bingo.sheets.infra.repositories;

import br.edu.ifce.bingo.games.infra.repository.documents.GameDocument;
import br.edu.ifce.bingo.sheets.infra.repositories.documents.SheetDocument;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

@Component
public class PersistSheetRepository implements IPersistSheetRepository {

    private final MongoTemplate database;

    public PersistSheetRepository(MongoTemplate database) {
        this.database = database;
    }

    @Override
    public void insert(PersistSheet persistSheet) {
        database.insert(
                new SheetDocument(
                        null,
                        persistSheet.gameId(),
                        persistSheet.listB(),
                        persistSheet.listI(),
                        persistSheet.listN(),
                        persistSheet.listG(),
                        persistSheet.listO(),
                        persistSheet.hash()
                )
        );
    }

    @Override
    public boolean existsByHash(String hash) {
        final var query = Query.query(Criteria.where("hash").is(hash));
        return !database.find(query, SheetDocument.class).isEmpty();
    }

}
