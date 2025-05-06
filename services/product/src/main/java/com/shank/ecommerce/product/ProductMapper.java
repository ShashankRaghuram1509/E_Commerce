package com.shank.ecommerce.product;

import java.util.List;

import org.springframework.stereotype.Service;

import com.shank.ecommerce.category.Category;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

@Service
public class ProductMapper {

	public Product toProduct(ProductRequest request) {
		// TODO Auto-generated method stub
		return Product.builder()
				.id(request.id())
				.name(request.name())
				.description(request.description())
				.price(request.price())
				.availableQuantity(request.availableQuantity())
				.category(Category.builder().id(request.categoryId()).build())
				.build();
	}
	
	public ProductResponse toProductResponse(Product product) {
		return new ProductResponse(
				product.getId(),
				product.getName(),
				product.getDescription(),
				product.getAvailableQuantity(),
				product.getPrice(),
				product.getCategory().getId(),
				product.getCategory().getName(),
				product.getCategory().getDescription()
				);
	}

	public ProductPurchaseResponse toproductPurchaseResponse(Product product, double quantity) {
	    return new ProductPurchaseResponse(
	            product.getId(),
	            product.getName(),
	            product.getDescription(),
	            product.getPrice(),
	            quantity // Corrected: directly use the 'quantity' value
	    );
	}
}


