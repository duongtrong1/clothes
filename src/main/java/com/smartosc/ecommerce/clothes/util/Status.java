package com.smartosc.ecommerce.clothes.util;

public enum Status {

    VALID(1),
    INVALID(0);

    private Integer value;

    Status(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }

}
