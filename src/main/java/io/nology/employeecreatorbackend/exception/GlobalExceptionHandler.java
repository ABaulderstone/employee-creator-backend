package io.nology.employeecreatorbackend.exception;

import io.nology.employeecreatorbackend.exception.response.ValidationErrorResponse;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalExceptionHandler {

  @ExceptionHandler(MethodArgumentNotValidException.class)
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  @ResponseBody
  public ValidationErrorResponse handleValidationExceptions(
    MethodArgumentNotValidException exception
  ) {
    ValidationErrorResponse errorResponse = new ValidationErrorResponse();
    List<FieldError> fieldErrors = exception
      .getBindingResult()
      .getFieldErrors();
    for (FieldError error : fieldErrors) {
      errorResponse.addError(error.getField(), error.getDefaultMessage());
    }

    return errorResponse;
  }
}
