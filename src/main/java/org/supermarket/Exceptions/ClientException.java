package org.supermarket.Exceptions;

import java.io.Serial;

public class ClientException extends RuntimeException {

    @Serial
    private static final long serialVersionUID = 1L;

    public ClientException(String message) {
        super(message);
    }
}

