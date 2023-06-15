package com.mongeat.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class GenericModel {
    private String id;

    protected GenericModel() {}

    protected GenericModel(String id) {
        this.id = id;
    }
}
