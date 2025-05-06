package com.shank.ecommerce.product;

import java.math.BigDecimal;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record ProductRequest(
		 Integer id,
		 @NotNull(message = "Product name is Required")
		 String name,
		 @NotNull(message = "Product description is Required")
		 String description,
		 @Positive(message = "Available Quantity should be Positive")
		 double availableQuantity,
		 @Positive(message = "Price should be Positive")
		 BigDecimal price,
		 @NotNull(message = "Price Category is Required")
		 Integer categoryId
		) {

}
