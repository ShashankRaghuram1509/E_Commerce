package com.shank.ecommerce.payment;

import java.math.BigDecimal;

import com.shank.ecommerce.Customer.CustomerResponse;
import com.shank.ecommerce.order.PaymentMethod;

public record PaymentRequest(
		BigDecimal amount,
		PaymentMethod paymentMethod,
		Integer orderId,
		String orderReference,
		CustomerResponse customer
		) {

}
