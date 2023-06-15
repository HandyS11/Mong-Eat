package com.mongeat.mappers;

public interface IMapper<M, D> {
    D toDto(M object);
    M toModel(D object);
}
