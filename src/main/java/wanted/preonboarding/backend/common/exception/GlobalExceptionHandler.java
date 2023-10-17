package wanted.preonboarding.backend.common.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(BusinessExceeption.class)
    protected ResponseEntity<ErrorResponse> businessException(BusinessExceeption e) {
        ErrorResponse errorBaseResponse = new ErrorResponse(e);
        return new ResponseEntity<>(errorBaseResponse, HttpStatus.BAD_REQUEST);
    }

}
