package com.ledger.exception;

import com.ledger.enums.ErrorCode;

public class BadRequestException extends BaseException{
    public BadRequestException(String message) {
        super(message);
    }

    public BadRequestException(ErrorCode errorCode) {
        super(errorCode);
    }

}
