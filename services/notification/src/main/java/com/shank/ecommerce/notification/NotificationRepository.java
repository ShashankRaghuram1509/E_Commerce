package com.shank.ecommerce.notification;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.shank.ecommerce.kafka.payment.PaymentConfirmation;

public interface NotificationRepository extends MongoRepository<Notification, String> {

}
