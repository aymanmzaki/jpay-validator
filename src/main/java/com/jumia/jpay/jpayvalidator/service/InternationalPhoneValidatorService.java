package com.jumia.jpay.jpayvalidator.service;

import org.springframework.stereotype.Service;

@Service
public interface InternationalPhoneValidatorService {
    boolean validate(String pattern, String phoneNumber);
}
