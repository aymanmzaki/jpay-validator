package com.jumia.jpay.jpayvalidator.service;


import com.jumia.jpay.jpayvalidator.model.CountryPhoneModel;
import com.jumia.jpay.jpayvalidator.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class InternationalPhoneValidatorImp implements InternationalPhoneValidatorService {
    @Autowired
    CountryRepository countryRepository;

    public CountryPhoneModel getCountryAndValidate(String phoneNumber) {
        int countryCode = Integer.valueOf(phoneNumber.substring(1, 4));
        return countryRepository.findOneByCode(countryCode).map(country -> {
            CountryPhoneModel countryPhoneModel = new CountryPhoneModel();
            countryPhoneModel.setCountry(country.getName());
            countryPhoneModel.setValid(validate(country.getPattern(), phoneNumber));
            countryPhoneModel.setCode(country.getCode().toString());
            return countryPhoneModel;
        }).orElse(new CountryPhoneModel());
    }

    @Override
    public boolean validate(String patternString, String phoneNumber) {
        Pattern pattern = Pattern.compile(patternString);
        Matcher matcher = pattern.matcher(phoneNumber);
        return matcher.matches();
    }
}
