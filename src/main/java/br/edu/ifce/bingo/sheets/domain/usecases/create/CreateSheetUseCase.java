package br.edu.ifce.bingo.sheets.domain.usecases.create;

import br.edu.ifce.bingo.sheets.domain.usecases.gateways.IPersistSheetGateway;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Component
public class CreateSheetUseCase implements ICreateSheetUseCase {

    private final IPersistSheetGateway persistSheetGateway;

    public CreateSheetUseCase(final IPersistSheetGateway persistSheetGateway) {
        this.persistSheetGateway = persistSheetGateway;
    }

    @Override
    @Transactional
    public CreateSheetOutput execute(CreateSheetInput input) {
        var hash = "";
        List<Integer> listB;
        List<Integer> listI;
        List<Integer> listN;
        List<Integer> listG;
        List<Integer> listO;
        do {
            listB = INumbers.randomB();
            listI = INumbers.randomI();
            listN = INumbers.randomN();
            listG = INumbers.randomG();
            listO = INumbers.randomO();
            final var text = "%s%s%s%s%s%s".
                    formatted(
                            input.gameId(),
                            listB,
                            listI,
                            listN,
                            listG,
                            listO
                    );
            hash = IHash.sha256(text);
        } while (persistSheetGateway.existsByHash(hash));

        persistSheetGateway.insert(
                new IPersistSheetGateway.PersistSheet(
                        input.gameId(),
                        listB,
                        listI,
                        listN,
                        listG,
                        listO,
                        hash
                )
        );

        return new CreateSheetOutput(
                listB,
                listI,
                listN,
                listG,
                listO,
                hash
        );
    }
}
