package br.edu.ifce.bingo.sheets.domain.usecases.create;

import br.edu.ifce.bingo.sheets.core.shared.IHash;
import br.edu.ifce.bingo.sheets.core.shared.INumbers;
import br.edu.ifce.bingo.sheets.infra.gateways.IPersistSheetGateway;
import br.edu.ifce.bingo.sheets.infra.repositories.IPersistSheetRepository;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class CreateSheetUseCase implements ICreateSheetUseCase {

    private final IPersistSheetRepository persistSheetRepository;
    private final IPersistSheetGateway persistSheetGateway;

    public CreateSheetUseCase(
            final IPersistSheetRepository persistSheetRepository,
            IPersistSheetGateway persistSheetGateway
    ) {
        this.persistSheetRepository = persistSheetRepository;
        this.persistSheetGateway = persistSheetGateway;
    }

    @Override
    @Transactional
    public CreateSheetOutput execute(CreateSheetInput input) {

        if (!persistSheetGateway.existsGameById(input.gameId())) {
            throw new RuntimeException("Não existe um jogo com o id '%s'".formatted(input.gameId()));
        }

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
        } while (persistSheetRepository.existsByHash(hash));

        persistSheetRepository.insert(
                new IPersistSheetRepository.PersistSheet(
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
