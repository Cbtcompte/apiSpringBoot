package springboot.pdl.pdl.projet.exceptions;

public class EntityNotFoundException extends RuntimeException{

    private ErrorCodes errorCodes;
    
    EntityNotFoundException(String message, Throwable cause){
        super(message, cause);
    }

    EntityNotFoundException(String message){
        super(message);
    }

    EntityNotFoundException(String message, Throwable cause, ErrorCodes _errorCodes){
        super(message, cause);
        this.errorCodes = _errorCodes;
    }

    
    public ErrorCodes getErrorCodes() {
        return this.errorCodes;
    }

    public void setErrorCodes(ErrorCodes errorCodes) {
        this.errorCodes = errorCodes;
    }
}
