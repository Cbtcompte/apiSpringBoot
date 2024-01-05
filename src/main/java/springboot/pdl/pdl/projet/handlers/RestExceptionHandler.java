package springboot.pdl.pdl.projet.handlers;

import java.sql.SQLIntegrityConstraintViolationException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import springboot.pdl.pdl.projet.exceptions.EntityNotFoundException;
import springboot.pdl.pdl.projet.exceptions.Errors;
import springboot.pdl.pdl.projet.exceptions.InvalidEntityException;

@RestControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler{
    
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<Errors> handleEntityNotFoundException(EntityNotFoundException entityNotFoundException,  WebRequest webRequest){
        final HttpStatus httpStatus = HttpStatus.NOT_FOUND;
        final Errors errors = new Errors.ErrorsBuilder(entityNotFoundException.getMessage(), httpStatus.value()).build();
        return new ResponseEntity<Errors>(errors, httpStatus);
    }

    @ExceptionHandler(InvalidEntityException.class)
    public ResponseEntity<Errors> handInvalidEntityException(InvalidEntityException invalidEntityException, WebRequest webRequest){
        final HttpStatus httpStatus = HttpStatus.BAD_REQUEST;
        final Errors errors = new Errors.ErrorsBuilder(invalidEntityException.getMessage(), httpStatus.value()).setErrors(invalidEntityException.getMessageErrors()).build();
        return new ResponseEntity<Errors>(errors, httpStatus);
    }

    @ExceptionHandler(SQLIntegrityConstraintViolationException.class)
    public ResponseEntity<Errors> handSQLIntegrityConstraintViolationException(SQLIntegrityConstraintViolationException sqlException, WebRequest webRequest){
        final HttpStatus httpStatus = HttpStatus.BAD_REQUEST;
        final Errors errors = new Errors.ErrorsBuilder(sqlException.getMessage(), httpStatus.value()).build();
        return new ResponseEntity<Errors>(errors, httpStatus);
    }


    @ExceptionHandler(UsernameNotFoundException.class)
    public ResponseEntity<Errors> handUsernameNotFoundException(UsernameNotFoundException usernameNotFoundException, WebRequest webRequest){
        final HttpStatus httpStatus = HttpStatus.NOT_FOUND;
        final Errors errors = new Errors.ErrorsBuilder(usernameNotFoundException.getMessage(), httpStatus.value()).build();
        System.out.println(errors);
        return new ResponseEntity<Errors>(errors, httpStatus);
    }
}
 
