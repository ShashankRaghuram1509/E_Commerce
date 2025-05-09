package com.shank.ecommerce.email;

import lombok.Getter;

public enum EmailTemplates {
	
	PAYMENT_CONFIRMATION("payment-confirmation.html", "Payment successfully processed"),
	ORDER_CONFIRMATION("order-confirmation.html", "Order Confirmation");
	
	@Getter
	private final String template;
	@Getter
	private final String subject;
	private EmailTemplates(String template, String subject) {
		this.template = template;
		this.subject = subject;
	}
	
}
