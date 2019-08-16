package org.pva.domain.field;

import org.pva.domain.cell.Cell;

import java.util.ArrayList;
import java.util.List;

public class MinedField {

    private final Integer rowNumber;

    private final Integer colNumber;

    private final Integer mineNumber;

    private final List<Cell> cells = new ArrayList<Cell>();

    public MinedField(Integer rowNumber, Integer colNumber, Integer mineNumber) {
        this.rowNumber = rowNumber;
        this.colNumber = colNumber;
        this.mineNumber = mineNumber;
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

    public List<Cell> getCells() {
        return cells;
    }



}
