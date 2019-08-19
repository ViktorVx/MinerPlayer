package org.pva.domain.abstraction.robot;

import org.pva.domain.abstraction.dto.InputDataDto;
import org.pva.domain.abstraction.dto.OutputDataDto;

abstract public class Robot {

    public abstract void refreshMemory(InputDataDto inputData);

    public abstract OutputDataDto makeDataForAction();

    public abstract Boolean isWorkComplete();

}
