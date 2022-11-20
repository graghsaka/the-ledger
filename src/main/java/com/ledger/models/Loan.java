package com.ledger.models;


import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Loan {
    private final Bank bank;
    private final Borrower borrower;
    private final int principal;
    private final int years;
    private final double interestRate;

    public Loan(Bank bank, Borrower borrower, int principal, int years, double interestRate) {
        this.bank = bank;
        this.borrower = borrower;
        this.principal = principal;
        this.years = years;
        this.interestRate = interestRate;
    }

    private final Map<Integer, Integer> loanPayments = new HashMap<>();

    public int getTotalAmount() {
        return (int) (principal + Math.ceil((principal*years*interestRate)/100));
    }

    public int getEmiAmount() {
        return (int) Math.ceil((getTotalAmount() / (12 * years * 1.0)));
    }

    public void addLumpSumAmount(int emiNumber, int lumpSumAmount) {
        if (loanPayments.containsKey(emiNumber)) {
            int curr = loanPayments.get(emiNumber);
            lumpSumAmount += curr;
        }
        loanPayments.put(emiNumber, lumpSumAmount);
    }

    public int getAmountPaid(int emiNumber) {
        int emiAmountPaid = getEmiAmount()*emiNumber;
        int lumpSumPaid = 0;

        for (Map.Entry<Integer, Integer> entry: loanPayments.entrySet()) {
            if (entry.getKey() <= emiNumber) {
                lumpSumPaid += entry.getValue();
            }
        }

        return Math.min(getTotalAmount(), emiAmountPaid + lumpSumPaid);
    }

    public int getRemainingEmis(int emiNumber) {
        return (int) Math.ceil((1.0* getTotalAmount()-getAmountPaid(emiNumber))/getEmiAmount());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Loan loan = (Loan) o;
        return bank.equals(loan.bank) && borrower.equals(loan.borrower);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bank, borrower);
    }
}