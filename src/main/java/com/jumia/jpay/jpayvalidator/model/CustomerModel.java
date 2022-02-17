package com.jumia.jpay.jpayvalidator.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CustomerModel{
    private int id;
    private String name;
    private String phone;
    private String status;
    private String country;
    private String code;
}
