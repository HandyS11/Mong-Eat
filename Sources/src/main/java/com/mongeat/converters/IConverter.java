package com.mongeat.converters;

/**
 * Converts a model object to an entity object and vice versa.
 *
 * @param <M> The model object.
 * @param <E> The entity object.
 */
public interface IConverter<M, E> {
    E toEntity(M object);
    M toModel(E object);
}
