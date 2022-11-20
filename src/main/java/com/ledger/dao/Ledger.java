package com.ledger.dao;

import com.ledger.models.LedgerKey;
import com.ledger.models.Loan;

import java.util.HashMap;
import java.util.Map;

public class Ledger {

    private Ledger() {

    }

    private static Map<LedgerKey, Loan> loanMap = null;

    public static Map<LedgerKey, Loan> getLoanMap() {
        if (loanMap == null) {
            loanMap = new HashMap<>();
        }

        return loanMap;
    }

}
