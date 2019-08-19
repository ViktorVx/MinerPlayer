package org.pva.domain.minesweeperInMemoryGameModul.field;

import org.pva.domain.minesweeperInMemoryGameModul.cell.Cell;
import org.pva.domain.minesweeperInMemoryGameModul.cell.FreeCell;
import org.pva.domain.minesweeperInMemoryGameModul.cell.MinedCell;

import java.util.Random;

public class MinedField extends Field {

    private final Integer rowNumber;

    private final Integer colNumber;

    private final Integer mineNumber;

    private final Cell[] cells;

    private MinedField(Integer rowNumber, Integer colNumber, Integer mineNumber) {
        this.rowNumber = rowNumber;
        this.colNumber = colNumber;
        this.mineNumber = mineNumber;
        cells = new Cell[rowNumber * colNumber];
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

    private Cell[] getCells() {
        return cells;
    }

    public Cell getCell(Integer row, Integer col) {
        if (row >= rowNumber || col >= colNumber || row < 0 || col <0) throw new IllegalArgumentException();
        return cells[row * colNumber + col];
    }

    public static Field generateRandomMinedField(Integer rowNumber, Integer colNumber, Integer mineNumber) {
        MinedField minedField = new MinedField(rowNumber, colNumber, mineNumber);
        final int[] mineCoords = new Random().ints(0, rowNumber * colNumber - 1).distinct().limit(mineNumber).toArray();
        for (int mineCoord : mineCoords) {
            minedField.cells[mineCoord] = new MinedCell(mineCoord / colNumber, mineCoord % colNumber);
        }

        for (int i = 0; i < minedField.getCells().length; i++) {
            Cell cell = minedField.getCells()[i];
            if (cell != null) continue;

            FreeCell freeCell = new FreeCell(i / colNumber, i % colNumber);
            freeCell.countNumberClosestMine(minedField);
            minedField.getCells()[i] = freeCell;

        }

        return minedField;
    }

    public static Field generateUnknownMinedField(Integer rowNumber, Integer colNumber, Integer mineNumber) {
        return new MinedField(rowNumber, colNumber, mineNumber);
    }

    public static void printField(Field minedField) {
        System.out.println("------------------------------");
        for (int i = 0; i < ((MinedField)minedField).getRowNumber(); i++) {
            for (int j = 0; j < ((MinedField)minedField).getColNumber(); j++) {
                Cell cell = ((MinedField)minedField).getCell(i, j);
                if (cell == null) {
                    System.out.print(" X ");
                    continue;
                }

                if (cell instanceof MinedCell) {
                    System.out.print(" * ");
                } else {
                    System.out.print(String.format(" %d ", ((FreeCell) cell).getNumberClosestMines()));
                }
            }
            System.out.println();
        }
        System.out.println("------------------------------");
    }


}
