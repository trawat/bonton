package com.hotelbeds.exceptions;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class HotelBedsConnectorException extends Exception {

    public static final long serialVersionUID = 1L;

    private final String errorMessage;
    private final String errorCode;

    public HotelBedsConnectorException(String errorCode, String errorMessage) {
        this(errorCode , errorMessage, null);
    }

    public HotelBedsConnectorException(String errorCode,String errorMessage, Throwable throwable) {
        super("HotelBedsConnectorException (Error "+errorCode+"  while performing operation "+errorMessage, throwable);
        this.errorMessage = errorMessage;
        this.errorCode = errorCode;
    }


}
