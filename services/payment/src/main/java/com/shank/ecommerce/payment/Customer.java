package com.shank.ecommerce.payment;

import org.springframework.validation.annotation.Validated;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

@Validated
public record Customer(
		String id,
		@NotNull(message="FirstName is Required")
		String firstname,
		@NotNull(message="LastName is Required")
		String lastname,
		@NotNull(message="Email is Required")
		@Email(message="The Customer email is not correctly formatted")
		String email
		) {

}
