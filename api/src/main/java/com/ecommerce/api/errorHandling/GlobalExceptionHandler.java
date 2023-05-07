package com.ecommerce.api.errorHandling;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.nio.file.AccessDeniedException;
import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<ErrorResponse> handleAllExceptions(Exception ex, WebRequest request) {
        List<String> details = new ArrayList<>();
        details.add(ex.getLocalizedMessage());
        ErrorResponse error = new ErrorResponse("Server Error", HttpStatus.INTERNAL_SERVER_ERROR.toString(), details);
        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }


    @ExceptionHandler(RecordNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleUserNotFoundException(RecordNotFoundException ex, WebRequest request) {
        List<String> details = new ArrayList<>();
        details.add(ex.getLocalizedMessage());
        ErrorResponse error = new ErrorResponse("Record Not Found", HttpStatus.NOT_FOUND.toString(), details);
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<ErrorResponse> handleUniqueViolation(DataIntegrityViolationException ex, WebRequest request) {
        List<String> details = new ArrayList<>();
        details.add("Unique Constraint Violation: " + ex.getMostSpecificCause().getMessage());
        ErrorResponse error = new ErrorResponse("Unique Constraint Violation", HttpStatus.CONFLICT.toString(), details);
        return new ResponseEntity<>(error, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(ResponseStatusException.class)
    public ResponseEntity<ErrorResponse> handleResponseStatusException(ResponseStatusException ex, WebRequest request) {
        List<String> details = new ArrayList<>();
        details.add(ex.getMostSpecificCause().getMessage());
        ErrorResponse error = new ErrorResponse(HttpStatusCode.valueOf(ex.getBody().getStatus()).toString(), HttpStatusCode.valueOf(ex.getBody().getStatus()).toString(), details);
        return new ResponseEntity<>(error, HttpStatusCode.valueOf(ex.getBody().getStatus()));
    }



    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        BindingResult result = ex.getBindingResult();
        List<FieldError> fieldErrors = result.getFieldErrors();

        // Create a list of validation errors
        List<String> errors = new ArrayList<>();
        for (FieldError fieldError : fieldErrors) {
            errors.add(fieldError.getDefaultMessage());
        }

        // Return the list of validation errors as a response
        ErrorResponse errorResponse = new ErrorResponse("Validation failed" , HttpStatus.BAD_REQUEST.toString(), errors);
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(AccessDeniedException.class)
    public ResponseEntity<ErrorResponse> handleAccessDeniedException(AccessDeniedException e) {
        String message = "You are not authorized to access this resource.";
        ErrorResponse errorResponse = new ErrorResponse(message, HttpStatus.FORBIDDEN.toString(), null);
        return new ResponseEntity<>(errorResponse, HttpStatus.FORBIDDEN);
    }


}


