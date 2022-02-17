package com.jumia.jpay.jpayvalidator.service;

import com.jumia.jpay.jpayvalidator.entity.Customer;
import com.jumia.jpay.jpayvalidator.model.CountryPhoneModel;
import com.jumia.jpay.jpayvalidator.model.CustomerModel;
import com.jumia.jpay.jpayvalidator.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    InternationalPhoneValidatorImp phoneValidatorService;

    public List<CustomerModel> getAllCustomers() {
        return customerRepository.findAll().stream()
                .map(customer -> mapToModel(customer))
                .sorted(Comparator.comparing(CustomerModel::getCountry)
                        .reversed()
                        .thenComparing(CustomerModel::getStatus)
                        .reversed())
                .collect(Collectors.toList());
    }

    private CustomerModel mapToModel(Customer customer) {

        CountryPhoneModel countryPhoneModel = phoneValidatorService.getCountryAndValidate(customer.getPhone());
        return CustomerModel.builder()
                .id(customer.getId())
                .name(customer.getName())
                .phone(customer.getPhone())
                .country(countryPhoneModel.getCountry())
                .code(countryPhoneModel.getCode())
                .status(countryPhoneModel.isValid() ? "Valid" : "Not Valid")
                .build();
    }


}
