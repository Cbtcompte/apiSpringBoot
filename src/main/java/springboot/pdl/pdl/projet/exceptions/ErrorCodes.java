package springboot.pdl.pdl.projet.exceptions;

public enum ErrorCodes {
    DIAGRAMME_NOT_FOUND(1000),
    DIAGRAMME_NOT_VALID(2000);

    private int code;

    ErrorCodes(int _code){
        this.code = _code;
    }

    public int getCode() {
        return code;
    }
}
