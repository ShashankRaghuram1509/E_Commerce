package com.shank.ecommerce.product;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import jakarta.validation.constraints.NotNull;

public interface ProductRepository extends JpaRepository<Product, Integer>{

	List<Product> findAllByIdInOrderById(List<@NotNull(message = "Product is Mandatory") Integer> productIds);

}
