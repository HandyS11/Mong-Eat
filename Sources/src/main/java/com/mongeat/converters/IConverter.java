package com.mongeat.converters;

public interface IConverter<M, E> {
    E toEntity(M object);
    M toModel(E object);
}
