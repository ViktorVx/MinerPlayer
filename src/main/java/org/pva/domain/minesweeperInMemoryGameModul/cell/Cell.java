package org.pva.domain.minesweeperInMemoryGameModul.cell;

abstract public class Cell {

    private Integer row;

    private Integer col;

    Cell(Integer row, Integer col) {
        this.row = row;
        this.col = col;
    }

    Integer getRow() {
        return row;
    }

    public void setRow(Integer row) {
        this.row = row;
    }

    Integer getCol() {
        return col;
    }

    public void setCol(Integer col) {
        this.col = col;
    }
}
