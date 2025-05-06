package com.shank.ecommerce.orderline;

import com.shank.ecommerce.order.Order;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Entity
public class OrderLine {
	@Id
	@GeneratedValue
	
	private Integer id;
	@ManyToOne
	@JoinColumn(name = "order_id")
	private Order order;
	private Integer productId;
	private double quantity;

}
