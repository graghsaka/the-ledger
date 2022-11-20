package com.ledger.enums;

public enum ErrorCode {

    LOAN_NOT_EXISTS(4001,"Loan does not exist for the borrower"),
    LOAN_ALREADY_EXISTS(4002,"Loan already exists for the borrower"),



    COMMAND_PROCESSOR_NOT_FOUND(5001, "No processor found for input command");

    public String getMessage() {
        return message;
    }

    public int getCode() {
        return code;
    }

    private final String message;
    private final int code;

    ErrorCode(int code, String message) {
        this.code = code;
        this.message = message;
    }
}
