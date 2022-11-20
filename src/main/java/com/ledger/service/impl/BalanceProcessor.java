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

public class BalanceProcessor extends InputCommandProcessor {

    public BalanceProcessor() {
        setInputCommand(InputCommand.BALANCE);
    }

    @Override
    public void processInputCommand(String command) throws BadRequestException {
        String[] inputs = command.split(SPACE_REGEX);
        Bank bank = new Bank(inputs[0]);
        Borrower borrower = new Borrower(inputs[1]);
        int emiNumber = Integer.parseInt(inputs[2]);

        LedgerKey ledgerKey = new LedgerKey(bank, borrower);

        if (!Ledger.getLoanMap().containsKey(ledgerKey)) {
            throw new BadRequestException(ErrorCode.LOAN_NOT_EXISTS);
        }

        Loan loan = Ledger.getLoanMap().get(ledgerKey);
        System.out.println(bank.getName() + SPACE_REGEX + borrower.getName() + SPACE_REGEX + loan.getAmountPaid(emiNumber) + SPACE_REGEX + loan.getRemainingEmis(emiNumber));
    }
}
