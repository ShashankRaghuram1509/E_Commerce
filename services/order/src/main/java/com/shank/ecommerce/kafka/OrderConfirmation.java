package com.shank.ecommerce.kafka;

import java.math.BigDecimal;
import java.util.List;

import com.shank.ecommerce.Customer.CustomerResponse;
import com.shank.ecommerce.order.PaymentMethod;
import com.shank.ecommerce.product.PurchaseResponse;

public record OrderConfirmation(
		
		String orderReference,
		BigDecimal totalAmount,
		PaymentMethod paymentMethod,
		CustomerResponse customer,
		List<PurchaseResponse> products
		
		) {

}
