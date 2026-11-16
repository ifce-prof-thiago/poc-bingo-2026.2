package br.edu.ifce.bingo.sheets.application.controller;

import br.edu.ifce.bingo.sheets.domain.usecases.create.ICreateSheetUseCase;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/sheets")
@CrossOrigin("*")
public class SheetController {

    private final ICreateSheetUseCase createSheet;

    public SheetController(final ICreateSheetUseCase createSheet) {
        this.createSheet = createSheet;
    }

    @PostMapping
    public ICreateSheetUseCase.CreateSheetOutput generate(@RequestBody ICreateSheetUseCase.CreateSheetInput input) {
        return createSheet.execute(input);
    }
}
