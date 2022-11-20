package com.ledger.exception;

import com.ledger.enums.ErrorCode;

public class InternalServerException extends BaseException{
    public InternalServerException(String message) {
        super(message);
    }

    public InternalServerException(ErrorCode errorCode) {
        super(errorCode);
    }
}
