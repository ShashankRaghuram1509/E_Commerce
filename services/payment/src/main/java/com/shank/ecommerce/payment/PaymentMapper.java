package com.shank.ecommerce.payment;

import org.springframework.stereotype.Service;

import jakarta.validation.Valid;

@Service
public class PaymentMapper {

	public Payment toPayment(@Valid PaymentRequest request) {
		// TODO Auto-generated method stub
		return Payment.builder()
				.id(request.id())
				.orderId(request.orderId())
				.paymentMethod(request.paymentMethod())
				.amount(request.amount())
				.build();
	}

}
