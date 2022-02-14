package com.jumia.jpay.jpayvalidator.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Country {
    @Id
    private Integer code;
    private String name;
}
