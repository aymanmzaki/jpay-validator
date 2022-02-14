package com.jumia.jpay.jpayvalidator.service;

import com.jumia.jpay.jpayvalidator.entity.Customer;
import com.jumia.jpay.jpayvalidator.model.CustomerModel;
import com.jumia.jpay.jpayvalidator.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    public Optional<Customer> getCustomerByName(String name) {
        return customerRepository.findByName(name);
    }

    public List<CustomerModel> getAllCustomers() {
        return customerRepository.findAll().stream().map(customer -> {
            CustomerModel customerModel = mapToModel(customer);
            return customerModel;
        }).collect(Collectors.toList());
    }

    private CustomerModel mapToModel(Customer customer) {
        return CustomerModel.builder()
                .id(customer.getId())
                .name(customer.getName())
                .phone(customer.getPhone())
                .country("N/A")
                .valid(false)
                .build();
    }


}