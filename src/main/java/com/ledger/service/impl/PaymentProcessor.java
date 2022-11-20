package com.ledger.service.impl;

import com.ledger.dao.Ledger;
import com.ledger.enums.ErrorCode;
import com.ledger.enums.InputCommand;
import com.ledger.exception.BadRequestException;
import com.ledger.models.Bank;
import com.ledger.models.Borrower;
import com.ledger.models.LedgerKey;
import com.ledger.models.Loan;
import com.ledger.service.InputCommandProcessor;

import static com.ledger.constants.Constants.SPACE_REGEX;

public class PaymentProcessor extends InputCommandProcessor {

    public PaymentProcessor() {
        setInputCommand(InputCommand.PAYMENT);
    }

    @Override
    public void processInputCommand(String command) throws BadRequestException {
        String[] inputs = command.split(SPACE_REGEX);
        Bank bank = new Bank(inputs[0]);
        Borrower borrower = new Borrower(inputs[1]);
        int lumpSumAmount = Integer.parseInt(inputs[2]);
        int emiNumber = Integer.parseInt(inputs[3]);

        LedgerKey ledgerKey = new LedgerKey(bank, borrower);

        if (!Ledger.getLoanMap().containsKey(ledgerKey)) {
            throw new BadRequestException(ErrorCode.LOAN_NOT_EXISTS);
        }

        Loan loan = Ledger.getLoanMap().get(ledgerKey);
        loan.addLumpSumAmount(emiNumber, lumpSumAmount);

        Ledger.getLoanMap().put(ledgerKey, loan);
    }
}
