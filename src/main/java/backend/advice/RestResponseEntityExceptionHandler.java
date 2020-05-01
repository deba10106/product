package backend.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import backend.exception.ProductNotFoundException;
import backend.exception.UploadException;

@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(Exception.class)
    public final ResponseEntity<?> handleAllExceptions(Exception ex, WebRequest request) {
        return new ResponseEntity<String>("The server has encountered an error.", HttpStatus.INTERNAL_SERVER_ERROR);
    }
	
	@ExceptionHandler(ProductNotFoundException.class)
    public final ResponseEntity<?> handleInvalidUsernameOrPasswordException(Exception ex, WebRequest request) {
        return new ResponseEntity<String>(ex.getMessage(), HttpStatus.UNAUTHORIZED);
    }
	
	@ExceptionHandler(UploadException.class)
    public final ResponseEntity<?> handleUploadFailure(Exception ex, WebRequest request) {
        return new ResponseEntity<String>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
	
}
