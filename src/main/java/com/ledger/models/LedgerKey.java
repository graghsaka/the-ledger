package com.ledger.models;


import java.util.Objects;

public class LedgerKey {
    private Bank bank;
    private Borrower borrower;

    public LedgerKey(Bank bank, Borrower borrower) {
        this.bank = bank;
        this.borrower = borrower;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LedgerKey ledgerKey = (LedgerKey) o;
        return bank.equals(ledgerKey.bank) && borrower.equals(ledgerKey.borrower);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bank, borrower);
    }

    public Bank getBank() {
        return bank;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }

    public Borrower getBorrower() {
        return borrower;
    }

    public void setBorrower(Borrower borrower) {
        this.borrower = borrower;
    }
}
