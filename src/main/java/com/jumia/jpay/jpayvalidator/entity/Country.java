package com.jumia.jpay.jpayvalidator.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class Country {
    @Id
    private Integer code;
    private String name;
    private String pattern;
}
