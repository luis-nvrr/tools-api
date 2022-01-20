package com.bossabox.toolsapi.exceptions;

import com.bossabox.toolsapi.dtos.ExceptionResponse;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionsHandler {

  @ExceptionHandler(ToolNotFoundException.class)
  public ResponseEntity<ExceptionResponse> handleError(ToolNotFoundException ex) {
    ExceptionResponse response = new ExceptionResponse(HttpStatus.NOT_FOUND.value(), ex.getMessage());
    return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
  }
}
