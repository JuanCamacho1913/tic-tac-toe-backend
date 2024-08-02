package com.tic.tac.toe.domain.exceptions;

public class ClubListEmptyException extends RuntimeException{

    public ClubListEmptyException() {
        super();
    }

    public ClubListEmptyException(String message) {
        super(message);
    }

    public ClubListEmptyException(String message, Throwable cause) {
        super(message, cause);
    }

    public ClubListEmptyException(Throwable cause) {
        super(cause);
    }
}
