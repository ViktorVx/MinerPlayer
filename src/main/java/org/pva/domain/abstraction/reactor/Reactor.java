package org.pva.domain.abstraction.reactor;

import org.pva.domain.abstraction.dto.InputDataDto;
import org.pva.domain.abstraction.dto.OutputDataDto;
import org.pva.domain.abstraction.dto.ResultDataDto;
import org.pva.domain.abstraction.robot.Robot;

public abstract class Reactor {

    private Robot robot;
//    private InputDataDto inputDataDto; // data from outside system
//    private OutputDataDto outputDataDto; // data to outside system

    public abstract InputDataDto getInputData();

    public abstract void makeAction(OutputDataDto outputData);

    public abstract ResultDataDto analyseCurrentState(InputDataDto inputData);

    public abstract void start();

}
