package org.pva;

import org.pva.domain.minesweeperInMemoryGameModul.MinesweeperReactor;
import org.pva.domain.minesweeperInMemoryGameModul.MinesweeperStartData;
import org.pva.domain.minesweeperInMemoryGameModul.field.Field;
import org.pva.domain.minesweeperInMemoryGameModul.field.MinedField;

class MainTest {

    @org.junit.jupiter.api.Test
    void main() {
        // Start data
        final Integer ROW_NUMBER = 10;
        final Integer COL_NUMBER = 10;
        final Integer MINE_NUMBER = 20;

        // Virtual field
        final Field virtualMinedField = MinedField.generateRandomMinedField(ROW_NUMBER, COL_NUMBER, MINE_NUMBER);
        MinedField.printField(virtualMinedField);

        // ***
        MinesweeperReactor reactor = new MinesweeperReactor(new MinesweeperStartData(ROW_NUMBER, COL_NUMBER, MINE_NUMBER));

        // ***

    }
}