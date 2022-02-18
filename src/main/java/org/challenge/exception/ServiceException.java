package org.challenge.exception;

public class ServiceException extends Exception {

    public ServiceException(Throwable exception) {
        super(exception);
    }

    public ServiceException(String exception) {
        super(exception);
    }
}
