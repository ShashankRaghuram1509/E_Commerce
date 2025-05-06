package com.shank.ecommerce.orderline;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface OrderLineRepository extends MongoRepository<OrderLine, Integer>{

		List<OrderLine> findAllByOrderId(Integer orderId);

}
