package com.ledger.service;

import com.ledger.enums.InputCommand;
import com.ledger.exception.BadRequestException;

//@Data
public abstract class InputCommandProcessor {
    protected InputCommand inputCommand;

    public abstract void processInputCommand(String command) throws BadRequestException;

    public InputCommand getInputCommand() {
        return inputCommand;
    }

    public void setInputCommand(InputCommand inputCommand) {
        this.inputCommand = inputCommand;
    }
}
