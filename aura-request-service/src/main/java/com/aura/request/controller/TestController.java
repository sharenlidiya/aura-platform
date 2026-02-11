package com.aura.request.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aura.request.dto.CreateRequestDto;
import com.aura.request.dto.ResponseEntity;
import com.aura.request.exception.ResourceNotFoundException;

import jakarta.validation.Valid;

@RestController
@RequestMapping("request/test")
public class TestController {

	@PostMapping
	public ResponseEntity<CreateRequestDto> createRequest(@Valid @RequestBody CreateRequestDto createRequestDto){
		return new ResponseEntity<>(true,"Request Created Successfully",createRequestDto);
	}
	
	@GetMapping("/error")
	public void throwError() {
		throw new ResourceNotFoundException("Request Not Found");
	}
}
