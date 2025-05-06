package com.shank.ecommerce.customer;

import lombok.RequiredArgsConstructor;

import org.apache.commons.lang.StringUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.shank.ecommerce.exception.CustomerNotFoundException;

import jakarta.validation.Valid;

import static java.lang.String.format;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor

public class CustomerService {
	
	private final CustomerRepository repository;
	private final CustomerMapper mapper;

	public String createCustomer(@Valid CustomerRequest request) {
		
		var customer = repository.save(mapper.toCustomer(request));
		
		return customer.getId();
	}

	public void updateCustomer(@Valid CustomerRequest request) {
		var customer = repository.findById(request.id())
				.orElseThrow(() -> new CustomerNotFoundException(
						format("Cannot update customer:: no customer found with the provided id:: %s", request.id())
						));
		
		mergeCustomer(customer, request);
		repository.save(customer);
		// TODO Auto-generated method stub
		
	}

	private void mergeCustomer(Customer customer, @Valid CustomerRequest request) {
		if (StringUtils.isNotBlank(request.firstname())) {
			customer.setFirstname(request.firstname());
		}
		if (StringUtils.isNotBlank(request.lastname())) {
			customer.setLastname(request.lastname());
		}
		if (StringUtils.isNotBlank(request.email())) {
			customer.setEmail(request.email());
		}
		if (request.address()!=null) {
			customer.setAddress(request.address());
		}
		// TODO Auto-generated method stub
		
	}

	public List<CustomerResponse> findAllCustomers() {
		// TODO Auto-generated method stub
		return repository.findAll()
				.stream()
				.map(mapper::fromCustomer)
				.collect(Collectors.toList());
	}

	public Boolean existsById(String customerId) {
		// TODO Auto-generated method stub
		return repository.findById(customerId)
				.isPresent();
	}

	public CustomerResponse findById(String customerId) {
		// TODO Auto-generated method stub
		return repository.findById(customerId)
				.map(mapper::fromCustomer)
				.orElseThrow(() -> new CustomerNotFoundException(format("No Customer found with the provide id:: %s", customerId)));
	}

	public void deleteCustomer(String customerId) {
		repository.deleteById(customerId);
		// TODO Auto-generated method stub
		
	}

}
