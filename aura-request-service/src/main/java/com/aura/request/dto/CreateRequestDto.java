package com.aura.request.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
public class CreateRequestDto {

	@NotBlank(message = "Request type is mandatory")
	private String type;

	@NotBlank(message = "Description is mandatory")
	private String description;

	@NotNull(message = "Amount is Required")
	@Positive(message = "Amount must be greater than Zero")
	private Double amount;
}
