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

    MinesweeperRobot(InputDataDto inputData) {
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

        // in first turn return a random coordinate
        if (isUnclearedField) {
            Random random = new Random();
            return new MinesweeperOutputData(
                    random.nextInt(rowNumber),
                    random.nextInt(colNumber),
                    false);
        }

        // make easy analyse: is there any cell that has
        // number of unknown cell equals number of closest mined cells
        OutputDataDto outputData = easyAnalyse();
        if (outputData != null) {
            return outputData;
        }


        return null;
    }

    private OutputDataDto easyAnalyse() {
        for (int i = 0; i < rowNumber; i++) {
            for (int j = 0; j < colNumber; j++) {
                Cell cell = visibleField.getCell(i, j);
                if (cell == null ||
                        cell instanceof MinedCell ||
                        (cell instanceof FreeCell && ((FreeCell) cell).getNumberClosestMines().equals(0))
                ) {
                    continue;
                } else {
                    if (cell instanceof FreeCell) {
                        Integer unknownCellsNumber = 0;
                        Integer targetI = null, targetJ = null;

                        if (i > 0 && j > 0) {
                            if (visibleField.getCell(i - 1, j - 1) == null) {
                                unknownCellsNumber++;
                                targetI = i - 1;
                                targetJ = j - 1;
                            }
                        }

                        if (i > 0) {
                            if (visibleField.getCell(i - 1, j) == null) {
                                unknownCellsNumber++;
                                targetI = i - 1;
                                targetJ = j;
                            }
                        }

                        if (i > 0 && j < visibleField.getColNumber() - 1) {
                            if (visibleField.getCell(i - 1, j + 1) == null) {
                                unknownCellsNumber++;
                                targetI = i - 1;
                                targetJ = j + 1;
                            }
                        }

                        if (j < visibleField.getColNumber() - 1) {
                            if (visibleField.getCell(i, j + 1) == null) {
                                unknownCellsNumber++;
                                targetI = i;
                                targetJ = j + 1;
                            }
                        }

                        if (i < visibleField.getRowNumber() - 1 && j < visibleField.getColNumber() - 1) {
                            if (visibleField.getCell(i + 1, j + 1) == null) {
                                unknownCellsNumber++;
                                targetI = i + 1;
                                targetJ = j + 1;
                            }
                        }

                        if (i < visibleField.getRowNumber() - 1) {
                            if (visibleField.getCell(i + 1, j) == null) {
                                unknownCellsNumber++;
                                targetI = i + 1;
                                targetJ = j;
                            }
                        }

                        if (i < visibleField.getRowNumber() - 1 && j > 0) {
                            if (visibleField.getCell(i + 1, j - 1) == null) {
                                unknownCellsNumber++;
                                targetI = i + 1;
                                targetJ = j - 1;
                            }
                        }

                        if (j > 0) {
                            if (visibleField.getCell(i, j - 1) == null) {
                                unknownCellsNumber++;
                                targetI = i;
                                targetJ = j - 1;
                            }
                        }

                        if (((FreeCell) cell).getNumberClosestMines().equals(unknownCellsNumber) && targetI != null) {
                            unclearedMinesNumber--;
                            OutputDataDto outputData = new MinesweeperOutputData(targetI, targetJ, true);
                            if (unclearedMinesNumber.equals(0))
                                ((MinesweeperOutputData) outputData).setRobotWins(true);
                            return outputData;
                        }
                    }
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
