package org.pva.domain.cell;

public class FreeCell extends Cell {

    private Integer numberClosestMines;

    public FreeCell(Integer rowNumber, Integer colNumber) {
        super(rowNumber, colNumber);
    }

    public Integer getNumberClosestMines() {
        return numberClosestMines;
    }

    public void setNumberClosestMines(Integer numberClosestMines) {
        this.numberClosestMines = numberClosestMines;
    }
}
