package in.thilak.spring_restful_webservice.socialmedia.error;

import org.springframework.http.HttpHeaders;
import java.time.LocalDate;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import in.thilak.spring_restful_webservice.socialmedia.exception.UserNotFoundException;

@ControllerAdvice
public class CustomExceptionErrorHandler extends ResponseEntityExceptionHandler{

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorDetails> handleAllExceptions(Exception ex, WebRequest request) {
        ErrorDetails errorDetails = new ErrorDetails(LocalDate.now(), ex.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ErrorDetails> handleUserNotExceptions(Exception ex, WebRequest request) {
        ErrorDetails errorDetails = new ErrorDetails(LocalDate.now(), ex.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    }


    protected ResponseEntity<Object> handleMethodArgumentNotValid(
        MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        ErrorDetails errorDetails = new ErrorDetails(LocalDate.now(), ex.getFieldError().getDefaultMessage(), request.getDescription(false));
        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    }

}
