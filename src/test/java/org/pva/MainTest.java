package org.pva;

import org.pva.domain.minesweeperInMemoryGameModule.MinesweeperReactor;
import org.pva.domain.minesweeperInMemoryGameModule.dto.MinesweeperStartData;
import org.pva.domain.minesweeperInMemoryGameModule.field.MinedField;

class MainTest {

    @org.junit.jupiter.api.Test
    void test001() {
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

        commonTest(TEST_NUMBER, ROW_NUMBER, COL_NUMBER, MINE_NUMBER, virtualField);
    }

    @org.junit.jupiter.api.Test
    void test002() {
        // Start data
        final Integer TEST_NUMBER = 2;
        final Integer ROW_NUMBER = 10;
        final Integer COL_NUMBER = 10;
        final Integer MINE_NUMBER = 30;
        String virtualField =   " 1  2  *  2  *  1  1  2  4  * \n" +
                                " 2  *  2  2  1  2  2  *  *  * \n" +
                                " *  3  2  1  1  2  *  4  *  * \n" +
                                " 2  3  *  2  2  *  4  5  4  3 \n" +
                                " *  2  1  3  *  5  *  *  *  1 \n" +
                                " 2  3  1  3  *  *  5  *  3  1 \n" +
                                " *  3  *  4  4  *  3  1  1  0 \n" +
                                " 1  4  *  4  *  2  1  0  1  1 \n" +
                                " 1  4  *  4  1  1  0  0  1  * \n" +
                                " *  3  *  2  0  0  0  0  1  1 ";

        commonTest(TEST_NUMBER, ROW_NUMBER, COL_NUMBER, MINE_NUMBER, virtualField);

//        MinedField.printField(MinedField.generateRandomMinedField(10, 10, 30));
    }

    void commonTest(Integer testNumber, Integer rowNumber, Integer colNumber, Integer mineNumber, String virtualField){
        System.out.println(String.format("Run test #%d (ROW=%d, COL=%d, MINE=%d)",
                testNumber, rowNumber, colNumber, mineNumber));
        //
        final MinedField virtualMinedField = MinedField.generateMinedFieldFromString(rowNumber, colNumber, mineNumber, virtualField);
        MinedField.printField(virtualMinedField);

        // ***
        MinesweeperReactor reactor = new MinesweeperReactor(new MinesweeperStartData(virtualMinedField));
        reactor.start();

        // ***
        System.out.println("-----------------------------------------------------------------------------------------");
    }
}