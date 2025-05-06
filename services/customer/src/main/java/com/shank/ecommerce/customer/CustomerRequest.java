package com.shank.ecommerce.customer;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

public record CustomerRequest(
		 String id,
		 @NotNull(message = "Customer FirstName is Required")
		 String firstname,
		 @NotNull(message = "Customer LastName is Required")
		 String lastname,
		 @NotNull(message = "Customer Email is Required")
		 @Email(message = "Customer FirstName is Required")
		 String email,
		 Address address
		
		) {

}
