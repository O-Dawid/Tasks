package pl.dawid.exception;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ExceptionHandlerExceptionResolver;

import pl.dawid.domain.UserType;

@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ExceptionHandlerExceptionResolver {

     @ExceptionHandler(UserValidationException.class)
     public ResponseEntity<Object> handleAllExceptions(Exception ex, WebRequest request) {
          return new ResponseEntity<Object>(new ApiError(HttpStatus.NOT_ACCEPTABLE, ex.getMessage(), ex),
                    HttpStatus.NOT_ACCEPTABLE);
     }

     @ExceptionHandler(HttpMessageNotReadableException.class)
     public ResponseEntity<Object> asdExceptions(Exception ex, WebRequest request) {
          List<UserType> enums = Arrays.asList(UserType.values());
          return new ResponseEntity<Object>(new ApiError(HttpStatus.NOT_ACCEPTABLE, "Choose role as: " + enums, ex),
                    HttpStatus.NOT_ACCEPTABLE);
     }
}