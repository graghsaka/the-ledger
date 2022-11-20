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

public class LoanProcessor extends InputCommandProcessor {

    public LoanProcessor() {
        setInputCommand(InputCommand.LOAN);
    }

    @Override
    public void processInputCommand(String command) throws BadRequestException {

        String[] inputs = command.split(SPACE_REGEX);

        Bank bank = new Bank(inputs[0]);
        Borrower borrower = new Borrower(inputs[1]);
        int principal =Integer.parseInt(inputs[2]);
        int years = Integer.parseInt(inputs[3]);
        double interestRate = Double.parseDouble(inputs[4]);

        Loan loan = new Loan(bank, borrower, principal, years, interestRate);

        if (Ledger.getLoanMap().containsKey(new LedgerKey(bank, borrower))) {
            throw new BadRequestException(ErrorCode.LOAN_ALREADY_EXISTS);
        }

        Ledger.getLoanMap().put(new LedgerKey(bank, borrower), loan);
    }
}
