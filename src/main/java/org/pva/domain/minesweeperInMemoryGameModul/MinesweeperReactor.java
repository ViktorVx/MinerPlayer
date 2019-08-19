package org.pva.domain.minesweeperInMemoryGameModul;

import org.pva.domain.abstraction.reactor.InputDataDto;
import org.pva.domain.abstraction.reactor.OutputDataDto;
import org.pva.domain.abstraction.reactor.Reactor;
import org.pva.domain.minesweeperInMemoryGameModul.field.MinedField;

public class MinesweeperReactor extends Reactor {

    private MinedField visibleField;

    public MinesweeperReactor(MinesweeperStartData startData) {
        visibleField = (MinedField) MinedField.generateUnknownMinedField(startData.getRowNumber(),
                startData.getColNumber(),
                startData.getMineNumber());
        //TODO stopped here!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
    }

    @Override
    public InputDataDto getInputData() {
        return null;
    }

    @Override
    public void makeAction(OutputDataDto outputData) {

    }

    @Override
    public void start() {

    }

    @Override
    public Boolean executesExitExpression() {
        return false;
    }
}
