package org.supermarket.Exceptions;

import java.io.Serial;

public class StockException extends RuntimeException {

    @Serial
    private static final long serialVersionUID = 2L;

    public StockException(String message) {
        super(message);
    }
}

