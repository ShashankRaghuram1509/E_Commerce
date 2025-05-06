package com.shank.ecommerce.product;

import java.math.BigDecimal;

import com.shank.ecommerce.category.Category;

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
@Entity
@Data
public class Product {
	
	@Id
	@GeneratedValue
	private Integer id;
	private String name;
	private String description;
	private double availableQuantity;
	private BigDecimal price;
	@ManyToOne
	@JoinColumn(name = "category_id")
	private Category category;

}
