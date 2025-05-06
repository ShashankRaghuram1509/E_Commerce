package com.shank.ecommerce.order;

import java.math.BigDecimal;
import java.util.List;

import com.shank.ecommerce.product.PurchaseRequest;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record OrderRequest(
		
		Integer id,
		String refernce,
		@Positive(message="Order Amount should be positive")
		BigDecimal amount,
		@NotNull(message="payement amount should be precised")
		PaymentMethod paymentMethod,
		@NotNull(message="Customer should be present")
		@NotEmpty(message="Customer should be present")
		@NotBlank(message="Customer should be present ")
		String customerId,
		@NotEmpty(message="You should purchse atleast one product")
		List<PurchaseRequest> products
		
		) {

}
