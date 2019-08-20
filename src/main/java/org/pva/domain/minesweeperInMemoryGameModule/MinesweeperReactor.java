package org.pva.domain.minesweeperInMemoryGameModule;

import org.pva.domain.abstraction.dto.InputDataDto;
import org.pva.domain.abstraction.dto.OutputDataDto;
import org.pva.domain.abstraction.reactor.Reactor;
import org.pva.domain.abstraction.robot.Robot;
import org.pva.domain.minesweeperInMemoryGameModule.cell.Cell;
import org.pva.domain.minesweeperInMemoryGameModule.cell.FreeCell;
import org.pva.domain.minesweeperInMemoryGameModule.cell.MinedCell;
import org.pva.domain.minesweeperInMemoryGameModule.dto.MinesweeperInputData;
import org.pva.domain.minesweeperInMemoryGameModule.dto.MinesweeperOutputData;
import org.pva.domain.minesweeperInMemoryGameModule.dto.MinesweeperStartData;
import org.pva.domain.minesweeperInMemoryGameModule.field.MinedField;

public class MinesweeperReactor extends Reactor {

    private MinedField virtualField;

    private MinedField visibleField;

    public MinesweeperReactor(MinesweeperStartData startData) {
        this.virtualField = startData.getVirtualField();

        this.visibleField = MinedField.generateUnknownMinedField(this.virtualField.getRowNumber(),
                this.virtualField.getColNumber(),
                this.virtualField.getMineNumber());
    }

    @Override
    public InputDataDto getInputData() {
        return new MinesweeperInputData(visibleField);
    }

    @Override
    public Boolean makeAction(OutputDataDto outputData) {
        Integer row = ((MinesweeperOutputData) outputData).getRow();
        Integer col = ((MinesweeperOutputData) outputData).getCol();
        Boolean markAsMinedCell = ((MinesweeperOutputData) outputData).isMarkedAsMinedCell();

        Cell cell = virtualField.getCell(row, col);

        if (cell instanceof MinedCell && !markAsMinedCell) return false;
        // *, 1-8 - if cell is mined - mark cell as mined
        // 1-8 - if cell if free but there are mines around it - do nothing
        // 0 - if cell is free and no mines around
        visibleField.setCell(row, col, cell);

        if (cell instanceof FreeCell && ((FreeCell) cell).getNumberClosestMines().equals(0)) {
            openSurroundCells(row, col);
        }

        return true;
    }

    private void openSurroundCells(Integer row, Integer col) {
        //TODO проверять здесь, что ячейка нулевая, иначе - останавливать распространение
        //TODO по аналогии!
        Cell cell;
        if (row > 0 && col > 0) {
            if (visibleField.getCell(row - 1, col - 1) == null) {
                cell = virtualField.getCell( row - 1, col - 1);
                visibleField.setCell(row - 1, col - 1, cell);
                if (cell instanceof FreeCell && ((FreeCell) cell).getNumberClosestMines().equals(0))
                    openSurroundCells(row - 1, col - 1);
            }
        }

        if (row > 0) {
            if (visibleField.getCell(row - 1, col) == null) {
                cell = virtualField.getCell( row - 1, col);
                visibleField.setCell(row - 1, col, virtualField.getCell( row - 1, col));
                if (cell instanceof FreeCell && ((FreeCell) cell).getNumberClosestMines().equals(0))
                    openSurroundCells(row - 1, col);
            }
        }

        if (row > 0 && col < visibleField.getColNumber() - 1) {
            if (visibleField.getCell(row - 1, col + 1) == null) {
                cell = virtualField.getCell( row - 1, col + 1);
                visibleField.setCell(row - 1, col + 1, virtualField.getCell(row - 1, col + 1));
                if (cell instanceof FreeCell && ((FreeCell) cell).getNumberClosestMines().equals(0))
                    openSurroundCells(row - 1, col + 1);
            }
        }
        if (col < visibleField.getColNumber() - 1) {
            if (visibleField.getCell(row, col +1) == null) {
                cell = virtualField.getCell(row, col + 1);
                visibleField.setCell(row, col + 1, virtualField.getCell(row, col + 1));
                if (cell instanceof FreeCell && ((FreeCell) cell).getNumberClosestMines().equals(0))
                    openSurroundCells(row, col + 1);
            }
        }

        if (row < visibleField.getRowNumber() - 1 && col< visibleField.getColNumber() - 1) {
            if (visibleField.getCell(row + 1, col + 1) == null) {
                cell = virtualField.getCell(row + 1, col + 1);
                visibleField.setCell(row + 1, col + 1, virtualField.getCell(row + 1, col + 1));
                if (cell instanceof FreeCell && ((FreeCell) cell).getNumberClosestMines().equals(0))
                    openSurroundCells(row + 1, col + 1);
            }
        }

        if (row < visibleField.getRowNumber() - 1) {
            if (visibleField.getCell(row + 1, col) == null) {
                cell = virtualField.getCell(row + 1, col);
                visibleField.setCell(row + 1, col, virtualField.getCell(row + 1, col));
                if (cell instanceof FreeCell && ((FreeCell) cell).getNumberClosestMines().equals(0))
                    openSurroundCells(row + 1, col);
            }
        }

        if (row < visibleField.getRowNumber() - 1 && col > 0) {
            if (visibleField.getCell(row + 1, col - 1) == null) {
                cell = virtualField.getCell(row + 1, col - 1);
                visibleField.setCell(row + 1, col - 1, virtualField.getCell(row + 1, col - 1));
                if (cell instanceof FreeCell && ((FreeCell) cell).getNumberClosestMines().equals(0))
                        openSurroundCells(row + 1, col - 1);
            }
        }

        if (col > 0) {
            if (visibleField.getCell(row, col - 1) == null) {
                cell = virtualField.getCell(row, col - 1);
                visibleField.setCell(row, col - 1, virtualField.getCell(row, col - 1));
                if (cell instanceof FreeCell && ((FreeCell) cell).getNumberClosestMines().equals(0))
                    openSurroundCells(row, col - 1);
            }
        }
    }

    @Override
    public void start() {
        Robot robot = new MinesweeperRobot(getInputData());
        // ***
        while (true) {
            OutputDataDto outputData = robot.makeDataForAction();
            if (!makeAction(outputData)) {
                System.out.println("Game over!");
                break;
            }
            robot.refreshMemory(new MinesweeperInputData(visibleField));
            MinedField.printField(visibleField);
        }
        // ***

    }

}
