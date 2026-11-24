package br.edu.ifce.bingo.games.infra.repository;

import br.edu.ifce.bingo.games.domain.models.SheetEntity;
import br.edu.ifce.bingo.games.infra.repository.documents.GameDocument;
import br.edu.ifce.bingo.sheets.infra.repositories.documents.SheetDocument;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class VerifyWinnerRepository implements IVerifyWinnerRepository {

    private final MongoTemplate database;

    public VerifyWinnerRepository(MongoTemplate database) {
        this.database = database;
    }

    @Override
    public List<SheetEntity> findSheetByGameId(String gameId) {
        final var query = Query.query(Criteria.where("gameId").is(gameId));
        final var documents = database.find(query, SheetDocument.class);
        var list = new ArrayList<SheetEntity>();
        for (var doc : documents) {
            final var numbers = new ArrayList<Integer>();
            numbers.addAll(doc.listB());
            numbers.addAll(doc.listI());
            numbers.addAll(doc.listN());
            numbers.addAll(doc.listG());
            numbers.addAll(doc.listO());
            list.add(
                    new SheetEntity(
                            doc.hash(),
                            numbers
                    )
            );
        }
        return list;
    }

    @Override
    public void updateGameByIdToWinnerTrue(String gameId) {
        final var query = Query.query(Criteria.where("gameId").is(gameId));
        final var update = new Update().set("hasWinner", true);
        database.updateFirst(query, update, GameDocument.class);
    }

    @Override
    public void updateSheetsToWinnerTrue(List<String> hashes) {
        final var query = Query.query(Criteria.where("hash").in(hashes));
        final var update = new Update().set("winner", true);
        database.updateMulti(query, update, SheetDocument.class);
    }
}
