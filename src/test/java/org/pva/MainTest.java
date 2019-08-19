package org.pva;

import org.pva.domain.minesweeperInMemoryGameModule.MinesweeperReactor;
import org.pva.domain.minesweeperInMemoryGameModule.dto.MinesweeperStartData;
import org.pva.domain.minesweeperInMemoryGameModule.field.MinedField;

class MainTest {

    @org.junit.jupiter.api.Test
    void main() {
        // Start data
        final Integer ROW_NUMBER = 10;
        final Integer COL_NUMBER = 10;
        final Integer MINE_NUMBER = 3;

        // Virtual field
        final MinedField virtualMinedField = (MinedField) MinedField.generateRandomMinedField(ROW_NUMBER, COL_NUMBER, MINE_NUMBER);
        MinedField.printField(virtualMinedField);

        // ***
        MinesweeperReactor reactor = new MinesweeperReactor(new MinesweeperStartData(virtualMinedField));
        reactor.start();

        // ***

    }
}