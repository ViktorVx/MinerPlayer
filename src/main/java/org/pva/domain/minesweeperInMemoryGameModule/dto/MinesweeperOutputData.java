package org.pva.domain.minesweeperInMemoryGameModule.dto;

import org.pva.domain.abstraction.dto.OutputDataDto;

public class MinesweeperOutputData extends OutputDataDto {

    private Integer row;

    private Integer col;

    private Boolean markMinedCell;

    private Boolean robotWins = false;

    public MinesweeperOutputData(Integer row, Integer col, Boolean markMinedCell) {
        this.row = row;
        this.col = col;
        this.markMinedCell = markMinedCell;
    }

    public Boolean isMarkedAsMinedCell() {
        return markMinedCell;
    }

    public void setMarkMinedCell(Boolean markMinedCell) {
        this.markMinedCell = markMinedCell;
    }

    public Integer getRow() {
        return row;
    }

    public void setRow(Integer row) {
        this.row = row;
    }

    public Integer getCol() {
        return col;
    }

    public void setCol(Integer col) {
        this.col = col;
    }

    public Boolean getRobotWins() {
        return robotWins;
    }

    public void setRobotWins(Boolean robotWins) {
        this.robotWins = robotWins;
    }
}
