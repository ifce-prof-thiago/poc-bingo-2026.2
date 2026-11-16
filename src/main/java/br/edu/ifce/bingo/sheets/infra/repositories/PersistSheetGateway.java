package br.edu.ifce.bingo.sheets.infra.repositories;

import br.edu.ifce.bingo.sheets.domain.usecases.gateways.IPersistSheetGateway;
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
