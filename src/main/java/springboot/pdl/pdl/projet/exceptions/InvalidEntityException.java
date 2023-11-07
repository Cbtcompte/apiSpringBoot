package springboot.pdl.pdl.projet.exceptions;

import java.util.Map;
import java.util.Iterator;

public class InvalidEntityException extends RuntimeException{
    
    private ErrorCodes errorCodes;
    private Map<String, String> messageErrors;

    public InvalidEntityException(String message, Throwable cause){
        super(message, cause);
    }

    public InvalidEntityException(String message){
        super(message);
    }

    public InvalidEntityException(String message, Throwable cause, ErrorCodes _errorCodes){
        super(message, cause);
        this.errorCodes = _errorCodes;
    }

    public InvalidEntityException(String message, Throwable cause, ErrorCodes _errorCodes, Map<String, String> _messageError){
        super(message, cause);
        this.errorCodes = _errorCodes;
        this.messageErrors = _messageError;
    }

    public InvalidEntityException(String message, ErrorCodes _errorCodes, Map<String, String> _messageError){
        super(message);
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
        return this.messageErrors.values().iterator();
    }

    public void setMessageErrors(Map<String, String> messageErrors) {
        this.messageErrors = messageErrors;
    }

}
