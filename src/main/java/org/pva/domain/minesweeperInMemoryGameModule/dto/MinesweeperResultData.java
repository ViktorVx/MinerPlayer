package org.pva.domain.minesweeperInMemoryGameModule.dto;

import org.pva.domain.abstraction.dto.ResultDataDto;

public class MinesweeperResultData extends ResultDataDto {

    private GameState gameState;

    public MinesweeperResultData(GameState gameState) {
            this.gameState = gameState;
    }

    public GameState getGameState() {
        return gameState;
    }
}
