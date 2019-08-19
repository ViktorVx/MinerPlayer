package org.pva.domain.minesweeperInMemoryGameModule;

import org.pva.domain.abstraction.dto.InputDataDto;
import org.pva.domain.abstraction.dto.OutputDataDto;
import org.pva.domain.abstraction.robot.Robot;
import org.pva.domain.minesweeperInMemoryGameModule.cell.Cell;
import org.pva.domain.minesweeperInMemoryGameModule.cell.FreeCell;
import org.pva.domain.minesweeperInMemoryGameModule.cell.MinedCell;
import org.pva.domain.minesweeperInMemoryGameModule.dto.MinesweeperInputData;
import org.pva.domain.minesweeperInMemoryGameModule.dto.MinesweeperOutputData;
import org.pva.domain.minesweeperInMemoryGameModule.field.MinedField;

import java.util.Random;

public class MinesweeperRobot extends Robot {

    private Integer unclearedMinesNumber;

    private final Integer totalMinesNumber;

    private final Integer rowNumber;

    private final Integer colNumber;

    private Boolean isUnclearedField = true;

    private MinedField visibleField;

    public MinesweeperRobot(InputDataDto inputData) {
        unclearedMinesNumber = ((MinesweeperInputData)inputData).getVisibleField().getMineNumber();
        visibleField = ((MinesweeperInputData)inputData).getVisibleField();

        totalMinesNumber = ((MinesweeperInputData)inputData).getVisibleField().getMineNumber();
        rowNumber = ((MinesweeperInputData)inputData).getVisibleField().getRowNumber();
        colNumber = ((MinesweeperInputData)inputData).getVisibleField().getColNumber();
    }

    @Override
    public void refreshMemory(InputDataDto inputData) {
        isUnclearedField = false;
        visibleField = ((MinesweeperInputData) inputData).getVisibleField();
    }

    @Override
    public OutputDataDto makeDataForAction() {

        if (isUnclearedField) {
            Random random = new Random();
            return new MinesweeperOutputData(
                    random.nextInt(rowNumber),
                    random.nextInt(colNumber),
                    false);
        }

        for (int i = 0; i < rowNumber; i++) {
            for (int j = 0; j < colNumber; j++) {
                Cell cell = visibleField.getCell(i, j);
                if (cell == null ||
                        cell instanceof MinedCell ||
                        (cell instanceof FreeCell && ((FreeCell) cell).getNumberClosestMines().equals(0))
                ) {
                    continue;
                } else {

                }
            }
        }
        return null;
    }

    @Override
    public Boolean isWorkComplete() {
        return unclearedMinesNumber.equals(0);
    }
}
