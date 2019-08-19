package org.pva.domain.abstraction.robot;

import org.pva.domain.abstraction.reactor.InputDataDto;
import org.pva.domain.abstraction.reactor.OutputDataDto;

abstract public class Robot {

    private CommandGenerator commandGenerator;

    public abstract void refreshMemory(InputDataDto inputData);

    public abstract OutputDataDto makeDataForAction();

}
