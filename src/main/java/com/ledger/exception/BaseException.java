package com.ledger.exception;

import com.ledger.enums.ErrorCode;

public class BaseException extends Exception{

    private int code;

    public BaseException(String message) {
        super(message);
    }

    public BaseException(ErrorCode errorCode) {
        super(errorCode.getMessage());
        this.code = errorCode.getCode();
    }
}
