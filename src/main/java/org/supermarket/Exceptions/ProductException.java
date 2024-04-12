package org.supermarket.Exceptions;

import java.io.Serial;

public class ProductException extends RuntimeException {

    @Serial
    private static final long serialVersionUID = 3L;

    public ProductException(String message) {
        super(message);
    }
}

