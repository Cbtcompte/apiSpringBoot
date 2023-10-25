package springboot.pdl.pdl.projet.exceptions;

import java.util.List;

import java.util.Iterator;

public class InvalidEntityException extends RuntimeException{
    
    private ErrorCodes errorCodes;
    private List<String> messageErrors;

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

    InvalidEntityException(String message, Throwable cause, ErrorCodes _errorCodes, List<String> _messageError){
        super(message, cause);
        this.errorCodes = _errorCodes;
        this.messageErrors = _messageError;
    }

    
    public ErrorCodes getErrorCodes() {
        return this.errorCodes;
    }

    public void setErrorCodes(ErrorCodes errorCodes) {
        this.errorCodes = errorCodes;
    }

    public Iterator<String> getMessageErrors() {
        return this.messageErrors.iterator();
    }

    public void setMessageErrors(List<String> messageErrors) {
        this.messageErrors = messageErrors;
    }

}
