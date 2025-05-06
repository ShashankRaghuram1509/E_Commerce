package com.shank.ecommerce.payment;

import org.springframework.stereotype.Service;

import com.shank.ecommerce.notification.NotificationProducer;
import com.shank.ecommerce.notification.PaymentNotificationRequest;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PaymentService {
	private final PaymentRepository repository;
	private final PaymentMapper mapper;
	private final NotificationProducer notificationProducer;
	
	public Integer createPayment(@Valid PaymentRequest request) {
		var payment = repository.save(mapper.toPayment(request));
		notificationProducer.sendNotification(
				new PaymentNotificationRequest(
						request.orderReference(),
						request.amount(),
						request.paymentMethod(),
						request.customer().firstname(),
						request.customer().lastname(),
						request.customer().email()
						)
				
				);
		// TODO Auto-generated method stub
		return payment.getId();
	}

}
