package com.mongeat.services;

import com.mongeat.entities.GenericEntity;
import com.mongeat.repositories.BaseRepository;

import java.util.Collection;

public abstract class GenericService<T extends GenericEntity> {

    protected BaseRepository<T> repository;

    public void setRepository(BaseRepository<T> repository) {
        this.repository = repository;
    }

    public T getById(String id) {
        return repository.findById(id);
    }

    public Collection<T> getAll() {
        return repository.getAll();
    }

    public T insert(T entity) {
        repository.insert(entity);
        return entity;
    }

    public Collection<T> insertAll(Collection<T> entities) {
        repository.insertAll(entities);
        return entities;
    }

    public void update(T entity) {
        repository.update(entity);
    }

    public void updateAll(Collection<T> entities) {
        repository.updateAll(entities);
    }

    public void delete(T entity) {
        repository.delete(entity);
    }

    public void deleteAll(Collection<T> entities) {
        repository.deleteAll(entities);
    }

    public void drop() {
        repository.getCollection().drop();
    }

    public void exists(String id) {
        repository.exists(id);
    }

    public double getCount() {
        return repository.count();
    }
}
