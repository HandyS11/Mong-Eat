package com.mongeat.repositories;

import com.mongeat.entities.GenericEntity;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.ReplaceOptions;
import org.bson.Document;
import org.bson.types.ObjectId;

import java.util.ArrayList;
import java.util.Collection;

import static com.mongodb.client.model.Filters.eq;

/**
 * GenericRepository
 */
public abstract class GenericRepository<T extends GenericEntity> extends BaseRepository {

    /**
     * @return The collection of the model
     */
    public abstract MongoCollection<T> getCollection();

    /**
     * @param id Id of the entity
     * @return The entity
     */
    public T findById(String id) {
        return getCollection().find(eq("_id", new ObjectId(id))).first();
    }

    /**
     * @return All entities
     */
    public Collection<T> getAll() {
        return getCollection().find().into(new ArrayList<>());
    }

    /**
     * @param page Page number
     * @param limit Number of entities per page
     * @return A paginated list of entities
     */
    public Collection<T> getPaginated(int page, int limit) {
        int skipCount = page * limit;
        return getCollection().find().skip(skipCount).limit(limit).into(new ArrayList<>());
    }

    /**
     * @param entity Entity to insert
     */
    public void insert(T entity) {
        getCollection().insertOne(entity);
    }

    /**
     * @param entities Entities to insert
     */
    public void insertAll(Collection<T> entities) {
        getCollection().insertMany(new ArrayList<>(entities));
    }

    /**
     * @param entity Entity to update
     */
    public void update(T entity) {
        getCollection().replaceOne(
                eq("_id", new ObjectId(entity.getId())),
                entity,
                new ReplaceOptions().upsert(true));
    }

    /**
     * @param entities Entities to update
     */
    public void updateAll(Collection<T> entities) {
        for (T entity : entities) {
            update(entity);
        }
    }

    /**
     * @param entity Entity to delete
     */
    public void delete(T entity) {
        getCollection().deleteOne(eq("_id", new ObjectId(entity.getId())));
    }

    /**
     * @param entities Entities to delete
     */
    public void deleteAll(Collection<T> entities) {
        for (T entity : entities) {
            delete(entity);
        }
    }

    /**
     * @param id Id of the entity to delete
     */
    public boolean exists(String id) {
        Document query = new Document("_id", new ObjectId(id));
        return getCollection().countDocuments(query) > 0;
    }

    /**
     * @return Number of entities
     */
    public long count() {
        return getCollection().countDocuments();
    }
}
