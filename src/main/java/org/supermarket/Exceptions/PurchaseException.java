package org.supermarket.Exceptions;

import java.io.Serial;

public class PurchaseException extends RuntimeException {

    @Serial
    private static final long serialVersionUID = 1L;

    public PurchaseException(String message) {
        super(message);
    }
}

