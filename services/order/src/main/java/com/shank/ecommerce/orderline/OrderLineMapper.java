package com.shank.ecommerce.orderline;

import org.springframework.stereotype.Service;

import com.shank.ecommerce.order.Order;

@Service
public class OrderLineMapper {

	public OrderLine toOrderLine(OrderLineRequest request) {
		// TODO Auto-generated method stub
		return OrderLine.builder()
				.id(request.id())
				.quantity(request.quantity())
				.order(
						Order.builder()
						.id(request.orderId())
						.build()
						)
				.productId(request.productId())
				.build();
				
	}
	public OrderLineResponse toOrderLineResponse(OrderLine orderLine) {
		return new OrderLineResponse(orderLine.getId(), orderLine.getQuantity());
	}

}
