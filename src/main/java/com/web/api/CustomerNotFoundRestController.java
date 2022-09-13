package com.web.api;

import com.web.error.CustomerNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/** CustomerNotFoundRestController */
@RestControllerAdvice
public class CustomerNotFoundRestController {
  @ExceptionHandler(value = {CustomerNotFoundException.class})
  private ResponseEntity<CustomerResponse> handleNotFoundCusomer(CustomerNotFoundException exc) {
    final CustomerResponse error =
        new CustomerResponse(
            exc.getMessage(), HttpStatus.NOT_FOUND.value(), System.currentTimeMillis());
    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
  }

  @ExceptionHandler(value = {Exception.class})
  private ResponseEntity<ApiResponse> handleNotFoundCusomer(Exception exc) {
    final ApiResponse error =
        new ApiResponse(
            "Something wrong with your path",
            HttpStatus.BAD_REQUEST.value(),
            System.currentTimeMillis());
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
  }
}
