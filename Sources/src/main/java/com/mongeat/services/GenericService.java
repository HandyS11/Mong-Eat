package com.mongeat.services;

import com.mongeat.converters.IConverter;
import com.mongeat.entities.GenericEntity;
import com.mongeat.repositories.GenericRepository;

import java.util.Collection;
import java.util.stream.Collectors;

public abstract class GenericService<M, E extends GenericEntity> {

    protected GenericRepository<E> repository;
    protected IConverter<M, E> converter;

    protected void setRepository(GenericRepository<E> repository) {
        this.repository = repository;
    }

    protected void setConverter(IConverter<M, E> converter) {
        this.converter = converter;
    }

    public M getById(String id) {
        E entity = repository.findById(id);
        return converter.toModel(entity);
    }

    public Collection<M> getAll() {
        Collection<E> entities = repository.getAll();
        return entities.stream().map(e -> converter.toModel(e)).collect(Collectors.toList());
    }

    public Collection<M> getPaginated(int page, int limit) {
        Collection<E> entities = repository.getPaginated(page, limit);
        return entities.stream().map(e -> converter.toModel(e)).collect(Collectors.toList());
    }

    public void insert(M model) {
        repository.insert(converter.toEntity(model));
    }

    public void insertAll(Collection<M> models) {
        repository.insertAll(models.stream().map(m -> converter.toEntity(m)).collect(Collectors.toList()));
    }

    public void update(M model) {
        repository.update(converter.toEntity(model));
    }

    public void updateAll(Collection<M> models) {
        repository.updateAll(models.stream().map(m -> converter.toEntity(m)).collect(Collectors.toList()));
    }

    public void delete(M model) {
        repository.delete(converter.toEntity(model));
    }

    public void deleteAll(Collection<M> models) {
        repository.deleteAll(models.stream().map(m -> converter.toEntity(m)).collect(Collectors.toList()));
    }

    public void drop() {
        repository.getCollection().drop();
    }

    public boolean exists(String id) {
        return repository.exists(id);
    }

    public long getCount() {
        return repository.count();
    }
}
