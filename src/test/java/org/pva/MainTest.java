package org.pva;

import org.pva.domain.minesweeperInMemoryGameModule.MinesweeperReactor;
import org.pva.domain.minesweeperInMemoryGameModule.dto.MinesweeperStartData;
import org.pva.domain.minesweeperInMemoryGameModule.field.MinedField;

class MainTest {

    @org.junit.jupiter.api.Test
    void main() {
        // Start data
        final Integer TEST_NUMBER = 1;
        final Integer ROW_NUMBER = 10;
        final Integer COL_NUMBER = 10;
        final Integer MINE_NUMBER = 3;
        String virtualField =   " 1  1  1  0  0  0  0  0  0  0 \n" +
                                " 1  *  1  0  0  0  0  0  0  0 \n" +
                                " 1  2  2  1  0  0  0  0  0  0 \n" +
                                " 0  1  *  1  0  0  0  0  0  0 \n" +
                                " 0  1  1  1  0  0  0  0  0  0 \n" +
                                " 0  0  0  0  0  0  0  0  0  0 \n" +
                                " 0  0  0  0  0  0  0  0  0  0 \n" +
                                " 0  0  0  0  0  0  0  0  0  0 \n" +
                                " 0  0  0  1  1  1  0  0  0  0 \n" +
                                " 0  0  0  1  *  1  0  0  0  0 ";
        //
        System.out.println(String.format("Run test #%d (ROW=%d, COL=%d, MINE=%d)",
                TEST_NUMBER, ROW_NUMBER, COL_NUMBER, MINE_NUMBER));
        //
        final MinedField virtualMinedField = MinedField.generateMinedFieldFromString(ROW_NUMBER, COL_NUMBER, MINE_NUMBER, virtualField);
        MinedField.printField(virtualMinedField);

        // ***
        MinesweeperReactor reactor = new MinesweeperReactor(new MinesweeperStartData(virtualMinedField));
        reactor.start();

        // ***
        System.out.println("-----------------------------------------------------------------------------------------");
    }
}