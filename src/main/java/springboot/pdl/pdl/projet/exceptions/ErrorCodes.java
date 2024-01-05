package springboot.pdl.pdl.projet.exceptions;

public enum ErrorCodes {
    DIAGRAMME_NOT_FOUND(1000),
    DIAGRAMME_NOT_VALID(2000),

    BUBBLE_NOT_FOUND(3000),
    BUBBLE_NOT_VALID(4000),
    FILE_NOT_FOUND(5000),
    FILE_NOT_VALID(6000);

    private int code;

    ErrorCodes(int _code){
        this.code = _code;
    }

    public int getCode() {
        return code;
    }

}
