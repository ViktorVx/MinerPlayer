package org.pva.domain.minesweeperInMemoryGameModul.cell;

import org.pva.domain.minesweeperInMemoryGameModul.field.MinedField;

public class FreeCell extends Cell {

    private Integer numberClosestMines;

    public FreeCell(Integer row, Integer col) {
        super(row, col);
    }

    public Integer getNumberClosestMines() {
        return numberClosestMines;
    }

    public void countNumberClosestMine(MinedField minedField) {
        Integer closestMines = 0;

        if (getRow() > 0 && getCol() > 0 &&
                minedField.getCell(getRow() - 1, getCol() - 1) instanceof MinedCell) closestMines++;
        if (getRow() > 0 &&
                minedField.getCell(getRow() - 1, getCol()) instanceof MinedCell) closestMines++;
        if (getRow() > 0 && getCol() < minedField.getColNumber() - 1 &&
                minedField.getCell(getRow() - 1, getCol() + 1) instanceof MinedCell) closestMines++;
        if (getCol() < minedField.getColNumber() - 1 &&
                minedField.getCell(getRow(), getCol() + 1) instanceof MinedCell) closestMines++;
        if (getRow() < minedField.getRowNumber() - 1 && getCol() < minedField.getColNumber() - 1 &&
                minedField.getCell(getRow() + 1, getCol() + 1) instanceof MinedCell) closestMines++;
        if (getRow() < minedField.getRowNumber() - 1 &&
                minedField.getCell(getRow() + 1, getCol()) instanceof MinedCell) closestMines++;
        if (getRow() < minedField.getRowNumber() - 1 && getCol() > 0 &&
                minedField.getCell(getRow() + 1, getCol() - 1) instanceof MinedCell) closestMines++;
        if (getCol() > 0 &&
                minedField.getCell(getRow(), getCol() - 1) instanceof MinedCell) closestMines++;

        numberClosestMines = closestMines;

    }
}
