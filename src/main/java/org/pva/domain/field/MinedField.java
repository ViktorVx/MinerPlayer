package org.pva.domain.field;

import org.pva.domain.cell.Cell;
import org.pva.domain.cell.FreeCell;
import org.pva.domain.cell.MinedCell;

import java.util.Random;

public class MinedField {

    private final Integer rowNumber;

    private final Integer colNumber;

    private final Integer mineNumber;

    class Container {
        Cell cell;

        Cell getCell() {
            return cell;
        }

        void setCell(Cell cell) {
            this.cell = cell;
        }
    }

    private final Container[] cells;

    private MinedField(Integer rowNumber, Integer colNumber, Integer mineNumber) {
        this.rowNumber = rowNumber;
        this.colNumber = colNumber;
        this.mineNumber = mineNumber;
        cells = new Container[rowNumber * colNumber];
    }

    public Integer getMineNumber() {
        return mineNumber;
    }

    public Integer getRowNumber() {
        return rowNumber;
    }

    public Integer getColNumber() {
        return colNumber;
    }

    private Container[] getCells() {
        return cells;
    }

    public Cell getCell(Integer row, Integer col) {
        if (row >= rowNumber || col >= colNumber || row < 0 || col <0) throw new IllegalArgumentException();
        return cells[row * colNumber + col].getCell();
    }

    public static MinedField generateMinedField(Integer rowNumber, Integer colNumber, Integer mineNumber) {
        MinedField minedField = new MinedField(rowNumber, colNumber, mineNumber);
        final int[] mineCoords = new Random().ints(0, rowNumber * colNumber - 1).distinct().limit(mineNumber).toArray();
        for (int mineCoord : mineCoords) {
            minedField.cells[mineCoord].setCell(new MinedCell(mineCoord / colNumber, mineCoord % colNumber));
        }

        for (int i = 0; i < minedField.getCells().length; i++) {
            Container container = minedField.getCells()[i];
            if (container.getCell() != null) continue;

            FreeCell freeCell = new FreeCell(i / colNumber, i % colNumber);
            freeCell.countNumberClosestMine(minedField);

        }

        return minedField;
    }

}
