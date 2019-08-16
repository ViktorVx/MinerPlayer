package org.pva.domain.cell;

abstract public class Cell {

    private Integer rowNumber;

    private Integer colNumber;

    Cell(Integer rowNumber, Integer colNumber) {
        this.rowNumber = rowNumber;
        this.colNumber = colNumber;
    }

    public Integer getRowNumber() {
        return rowNumber;
    }

    public void setRowNumber(Integer rowNumber) {
        this.rowNumber = rowNumber;
    }

    public Integer getColNumber() {
        return colNumber;
    }

    public void setColNumber(Integer colNumber) {
        this.colNumber = colNumber;
    }
}
