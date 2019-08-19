package org.pva.domain.minesweeperInMemoryGameModule.dto;

import org.pva.domain.abstraction.dto.InputDataDto;
import org.pva.domain.minesweeperInMemoryGameModule.field.MinedField;

public class MinesweeperInputData extends InputDataDto {

    private final MinedField visibleField;

    public MinesweeperInputData(MinedField visibleField) {
        this.visibleField = visibleField;
    }

    public MinedField getVisibleField() {
        return visibleField;
    }
}
