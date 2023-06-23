package com.mongeat.mappers;

/**
 * Map Model to Dto and vice versa
 * @param <M> Model
 * @param <D> Dto
 */
public interface IMapper<M, D> {
    D toDto(M object);
    M toModel(D object);
}
