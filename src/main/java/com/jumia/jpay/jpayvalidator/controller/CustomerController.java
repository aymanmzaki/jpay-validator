package com.jumia.jpay.jpayvalidator.controller;

import com.jumia.jpay.jpayvalidator.model.CustomerModel;
import com.jumia.jpay.jpayvalidator.service.CustomerService;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.stream.Collectors;

@Log
@Controller
@RequestMapping(value = "/")
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @GetMapping
    public String listCustomers(@RequestParam(required=false , defaultValue = "") String country ,
                                @RequestParam(required=false, defaultValue = "") String status,
                                Model model) {
        List<CustomerModel> customerList = customerService.getAllCustomers();

        if (!country.isEmpty() && customerList != null && status.isEmpty()) {
            customerList = customerList.stream()
                    .filter(customerModel -> customerModel.getCountry().equalsIgnoreCase(country))
                    .collect(Collectors.toList());
        } else if (!country.isEmpty() && customerList != null && !status.isEmpty()) {
            customerList = customerList.stream().filter(customerModel -> customerModel.getCountry().equalsIgnoreCase(country)
                            && customerModel.getStatus().equalsIgnoreCase(status))
                    .collect(Collectors.toList());
        }else if ( country.isEmpty() && customerList != null && !status.isEmpty()){
            customerList = customerList.stream().filter(customerModel -> customerModel.getStatus().equalsIgnoreCase(status))
                    .collect(Collectors.toList());
        }
        model.addAttribute("customerList", customerList);
        return "index";
    }
}
