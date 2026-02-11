package com.aura.request.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class GlobalExceptionHandler {

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<com.aura.request.dto.ResponseEntity<Object>> handleNotFound(ResourceNotFoundException ex) {
		return ResponseEntity.status(HttpStatus.NOT_FOUND)
				.body(new com.aura.request.dto.ResponseEntity<>(false, ex.getMessage(), null));
	}

	@ExceptionHandler(BadRequestException.class)
	public ResponseEntity<com.aura.request.dto.ResponseEntity<Object>> handleNotFound(BadRequestException ex) {
		return ResponseEntity.status(HttpStatus.BAD_REQUEST)
				.body(new com.aura.request.dto.ResponseEntity<>(false, ex.getMessage(), null));
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<com.aura.request.dto.ResponseEntity<Map<String, String>>> handleValidationErrors(
			MethodArgumentNotValidException ex) {

		Map<String, String> errors = new HashMap<>();
		ex.getBindingResult().getFieldErrors()
				.forEach(error -> errors.put(error.getField(), error.getDefaultMessage()));

		return ResponseEntity.status(HttpStatus.BAD_REQUEST)
				.body(new com.aura.request.dto.ResponseEntity<>(false, "Validation Failed", errors));
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<com.aura.request.dto.ResponseEntity<Object>> handleGeneric(Exception ex) {
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
				.body(new com.aura.request.dto.ResponseEntity<>(false, "Something Went Wrong", null));
	}
}
