package com.jumia.jpay.jpayvalidator.model;

import lombok.Data;

@Data
public class CountryPhoneModel {
    private  boolean valid;
    private String country;
    private String code;

    public CountryPhoneModel(){
        this.country="N/A";
        this.valid=false;
    }
}
