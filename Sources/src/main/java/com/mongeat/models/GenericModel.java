package com.mongeat.models;

import lombok.Getter;
import lombok.Setter;

/**
 * GenericModel
 */
@Getter
@Setter
public abstract class GenericModel {
    private String id;

    protected GenericModel() {}

    /**
     * @param id Id of the model
     */
    protected GenericModel(String id) {
        this.id = id;
    }
}
