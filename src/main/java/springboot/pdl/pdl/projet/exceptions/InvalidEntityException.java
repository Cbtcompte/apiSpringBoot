package springboot.pdl.pdl.projet.exceptions;

public class InvalidEntityException extends RuntimeException{
    
    private ErrorCodes errorCodes;

    InvalidEntityException(String message, Throwable cause){
        super(message, cause);
    }

    InvalidEntityException(String message){
        super(message);
    }

    InvalidEntityException(String message, Throwable cause, ErrorCodes _errorCodes){
        super(message, cause);
        this.errorCodes = _errorCodes;
    }
}
