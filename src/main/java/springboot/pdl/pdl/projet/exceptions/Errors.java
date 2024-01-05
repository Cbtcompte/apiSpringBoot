package springboot.pdl.pdl.projet.exceptions;

import java.util.HashMap;
import java.util.Map;

public class Errors {
     private Map<String, String> errorsList = new HashMap<>();
    private Integer httpCode;
    private String message;

    public Errors(ErrorsBuilder errorsBuilder){
        this.errorsList = errorsBuilder.errors;
        this.message = errorsBuilder.message;
        this.httpCode = errorsBuilder.httpCode;    
    }

    public Map<String, String> getErrorsList() {
        return this.errorsList;
    }

    public void setErrorsList(Map<String, String> errors) {
        this.errorsList = errors;
    }

    public Integer getHttpCode() {
        return this.httpCode;
    }

    public void setHttpCode(Integer httpCode) {
        this.httpCode = httpCode;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public static class ErrorsBuilder{

        private Map<String, String> errors = new HashMap<>();
        private Integer httpCode;
        private String message;

        public ErrorsBuilder(String _message, Integer _httpCode){
            this.message = _message;
            this.httpCode = _httpCode;    
        }

        public ErrorsBuilder setErrors(Map<String, String> errors) {
            this.errors = errors;

            return this;
        }

        public Errors build(){
            return new Errors(this);
        }
    }
}
