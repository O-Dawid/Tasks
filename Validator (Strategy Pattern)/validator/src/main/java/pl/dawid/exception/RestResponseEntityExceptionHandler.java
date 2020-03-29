package pl.dawid.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ExceptionHandlerExceptionResolver;

@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ExceptionHandlerExceptionResolver {

  @ExceptionHandler(UserValidationException.class)
  public ResponseEntity<Object> handleAllExceptions(Exception ex, WebRequest request) {
    return new ResponseEntity<Object>(HttpStatus.BAD_GATEWAY);
  }
}