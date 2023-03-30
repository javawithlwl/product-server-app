package com.careerit.psa.domain;

import lombok.Data;

@Data
public class Product {

    private Long id;
    private String name;
    private String description;
    private double price;
    private double discount;
    private boolean deleted;

}
