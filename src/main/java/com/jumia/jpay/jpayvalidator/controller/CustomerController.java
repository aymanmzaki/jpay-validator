package com.jumia.jpay.jpayvalidator.controller;

import com.jumia.jpay.jpayvalidator.entity.Customer;
import com.jumia.jpay.jpayvalidator.model.CustomerModel;
import com.jumia.jpay.jpayvalidator.service.CustomerService;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Log
@RestController
@RequestMapping(value = "/api/customer")
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @GetMapping(value = "/{name}")
    public ResponseEntity<Customer> getCustomerByName(@PathVariable String name) {
        return customerService.getCustomerByName(name).map(customer -> ResponseEntity.ok(customer))
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<CustomerModel>> listCustomers() {
        List<CustomerModel> customerList = customerService.getAllCustomers();
        if (customerList != null) {
            return ResponseEntity.ok(customerList);
        } else return ResponseEntity.notFound().build();
    }
}
