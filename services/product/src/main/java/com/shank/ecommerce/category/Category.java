package com.shank.ecommerce.category;

import java.math.BigDecimal;
import java.util.List;

import com.shank.ecommerce.product.Product;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Data
public class Category {
	@Id
	@GeneratedValue
	private Integer id;
	private String name;
	private String description;
	@OneToMany(mappedBy = "category", cascade = CascadeType.REMOVE)
	private List<Product> products;

}
 