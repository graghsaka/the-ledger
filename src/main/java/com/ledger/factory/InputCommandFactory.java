package com.ledger.factory;

import com.ledger.enums.ErrorCode;
import com.ledger.enums.InputCommand;
import com.ledger.exception.InternalServerException;
import com.ledger.service.InputCommandProcessor;
import com.ledger.service.impl.BalanceProcessor;
import com.ledger.service.impl.LoanProcessor;
import com.ledger.service.impl.PaymentProcessor;

public class InputCommandFactory {

    public InputCommandProcessor getInputCommandProcessor(InputCommand inputCommand) throws InternalServerException {

        if (inputCommand.equals(InputCommand.LOAN)) {
            return new LoanProcessor();
        } else if (inputCommand.equals(InputCommand.PAYMENT)) {
            return new PaymentProcessor();
        } else if (inputCommand.equals(InputCommand.BALANCE)) {
            return new BalanceProcessor();
        }

        throw new InternalServerException(ErrorCode.COMMAND_PROCESSOR_NOT_FOUND);
    }
}
