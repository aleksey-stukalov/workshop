package com.company.workshop.entity;

import com.haulmont.chile.core.datatypes.impl.EnumClass;

import javax.annotation.Nullable;


public enum OrderStatus implements EnumClass<Integer> {

    NEW(10),
    IN_PROGRESS(20),
    READY(30);

    private Integer id;

    OrderStatus(Integer value) {
        this.id = value;
    }

    public Integer getId() {
        return id;
    }

    @Nullable
    public static OrderStatus fromId(Integer id) {
        for (OrderStatus at : OrderStatus.values()) {
            if (at.getId().equals(id)) {
                return at;
            }
        }
        return null;
    }
}