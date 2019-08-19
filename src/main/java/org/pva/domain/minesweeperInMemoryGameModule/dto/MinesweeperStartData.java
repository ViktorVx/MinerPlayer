package org.pva.domain.minesweeperInMemoryGameModule.dto;

import org.pva.domain.abstraction.dto.StartDataDto;
import org.pva.domain.minesweeperInMemoryGameModule.field.MinedField;

public class MinesweeperStartData extends StartDataDto {

    private final MinedField virtualField;


    public MinesweeperStartData(MinedField virtualField) {
        this.virtualField = virtualField;
    }

    public MinedField getVirtualField() {
        return virtualField;
    }
}
