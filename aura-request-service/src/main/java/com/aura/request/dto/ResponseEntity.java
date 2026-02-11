package com.aura.request.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseEntity<T> {

	private boolean status;

	private String message;

	private T data;

}
