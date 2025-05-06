package com.shank.ecommerce.product;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.shank.ecommerce.exceptions.ProductPurchaseException;

import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductService {
	
	private final ProductRepository repository;
	private final ProductMapper mapper;
	
	public Integer createProduct(@Valid ProductRequest request) {
		var product = mapper.toProduct(request);
		// TODO Auto-generated method stub
		return repository.save(product).getId();

		// TODO Auto-generated method stub
		
	}

public List<ProductPurchaseResponse> purchaseProducts(List<ProductPurchaseRequest> request) {
	var productIds = request
			.stream()
			.map(ProductPurchaseRequest::productId)
			.toList();
	var storedProducts = repository.findAllByIdInOrderById(productIds);
	if(productIds.size() != storedProducts.size()) {
		throw new ProductPurchaseException("One or more products does not exists");
	}
	var storedRequest = request
			.stream()
			.sorted(Comparator.comparing(ProductPurchaseRequest::productId))
			.toList();
	var purchasedProducts = new ArrayList<ProductPurchaseResponse>();
	for(int i=0;i< storedProducts.size();i++) {
		var product = storedProducts.get(i);
		var productRequest = storedRequest.get(i);
		if (product.getAvailableQuantity() < productRequest.quantity()) {
			throw new ProductPurchaseException("Insufficient stock quantity for product with ID:: "+productRequest.productId());
		}
        var newAvailableQuantity = product.getAvailableQuantity() - productRequest.quantity();
        product.setAvailableQuantity(newAvailableQuantity);
        repository.save(product);
        purchasedProducts.add(mapper.toproductPurchaseResponse(product, productRequest.quantity()));
		
	}
	return purchasedProducts;
	}

public ProductResponse findById(Integer productId) {
	
	// TODO Auto-generated method stub
	return repository.findById(productId)
			.map(mapper :: toProductResponse)
			.orElseThrow(() -> new EntityNotFoundException("Product not Dound with the Id:: " + productId ));
}

public List<ProductResponse> findAll() {
	// TODO Auto-generated method stub
return repository.findAll()
		.stream()
		.map(mapper::toProductResponse)
		.collect(Collectors.toList());
}

}
