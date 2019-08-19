package org.pva.domain.minesweeperInMemoryGameModul;

import org.pva.domain.abstraction.reactor.StartDataDto;

public class MinesweeperStartData extends StartDataDto {

    private final Integer rowNumber;

    private final Integer colNumber;

    private final Integer mineNumber;

    public MinesweeperStartData(Integer rowNumber, Integer colNumber, Integer mineNumber) {
        this.rowNumber = rowNumber;
        this.colNumber = colNumber;
        this.mineNumber = mineNumber;
    }

    Integer getRowNumber() {
        return rowNumber;
    }

    Integer getColNumber() {
        return colNumber;
    }

    Integer getMineNumber() {
        return mineNumber;
    }
}
