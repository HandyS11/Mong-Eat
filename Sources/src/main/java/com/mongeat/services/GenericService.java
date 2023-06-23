package com.mongeat.services;

import com.mongeat.converters.IConverter;
import com.mongeat.entities.GenericEntity;
import com.mongeat.repositories.GenericRepository;

import java.util.Collection;
import java.util.stream.Collectors;

/**
 * GenericService
 */
public abstract class GenericService<M, MA, E extends GenericEntity> {
    protected GenericRepository<E> repository;
    protected IConverter<M, E> converter;
    protected IConverter<MA, E> addConverter;

    /**
     * Sets the repository to be used by this service.
     *
     * @param repository The repository to be used by this service.
     */
    protected void setRepository(GenericRepository<E> repository) {
        this.repository = repository;
    }

    /**
     * Sets the converter to be used by this service.
     *
     * @param converter The converter to be used by this service.
     */
    protected void setConverter(IConverter<M, E> converter) {
        this.converter = converter;
    }

    /**
     * Sets the add converter to be used by this service.
     *
     * @param addConverter The add converter to be used by this service.
     */
    protected void setAddConverter(IConverter<MA, E> addConverter) {
        this.addConverter = addConverter;
    }

    /**
     * @param id Id of the entity
     * @return The entity
     */
    public M getById(String id) {
        E entity = repository.findById(id);
        return converter.toModel(entity);
    }

    /**
     * @return All entities
     */
    public Collection<M> getAll() {
        Collection<E> entities = repository.getAll();
        return entities.stream().map(e -> converter.toModel(e)).collect(Collectors.toList());
    }

    /**
     * @param page  Page number
     * @param limit Number of entities per page
     * @return A paginated list of entities
     */
    public Collection<M> getPaginated(int page, int limit) {
        Collection<E> entities = repository.getPaginated(page, limit);
        return entities.stream().map(e -> converter.toModel(e)).collect(Collectors.toList());
    }

    /**
     * @param model Model to insert
     */
    public void insert(MA model) {
        repository.insert(addConverter.toEntity(model));
    }

    /**
     * @param models Models to insert
     */
    public void insertAll(Collection<MA> models) {
        repository.insertAll(models.stream().map(m -> addConverter.toEntity(m)).collect(Collectors.toList()));
    }

    /**
     * @param model Model to update
     */
    public void update(M model) {
        repository.update(converter.toEntity(model));
    }

    /**
     * @param models Models to update
     */
    public void updateAll(Collection<M> models) {
        repository.updateAll(models.stream().map(m -> converter.toEntity(m)).collect(Collectors.toList()));
    }

    /**
     * @param model Model to replace
     */
    public void delete(M model) {
        repository.delete(converter.toEntity(model));
    }

    /**
     * @param models Models to replace
     */
    public void deleteAll(Collection<M> models) {
        repository.deleteAll(models.stream().map(m -> converter.toEntity(m)).collect(Collectors.toList()));
    }

    /**
     * Drops the collection
     */
    public void drop() {
        repository.getCollection().drop();
    }

    /**
     * @param id Id of the entity
     * @return True if the entity exists, false otherwise
     */
    public boolean exists(String id) {
        return repository.exists(id);
    }

    /**
     * @return The number of entities
     */
    public long getCount() {
        return repository.count();
    }
}
