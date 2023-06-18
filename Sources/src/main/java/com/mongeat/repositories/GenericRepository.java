package com.mongeat.repositories;

import com.mongeat.entities.GenericEntity;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.ReplaceOptions;
import org.bson.Document;
import org.bson.types.ObjectId;

import java.util.ArrayList;
import java.util.Collection;

import static com.mongodb.client.model.Filters.eq;

public abstract class GenericRepository<T extends GenericEntity> extends BaseRepository {

    public abstract MongoCollection<T> getCollection();

    public T findById(String id) {
        return getCollection().find(eq("_id", new ObjectId(id))).first();
    }

    public Collection<T> getAll() {
        return getCollection().find().into(new ArrayList<>());
    }

    public Collection<T> getPaginated(int page, int limit) {
        int skipCount = page * limit;
        return getCollection().find().skip(skipCount).limit(limit).into(new ArrayList<>());
    }

    public void insert(T entity) {
        getCollection().insertOne(entity);
    }

    public void insertAll(Collection<T> entities) {
        getCollection().insertMany(new ArrayList<>(entities));
    }

    public void update(T entity) {
        getCollection().replaceOne(
                eq("_id", new ObjectId(entity.getId())),
                entity,
                new ReplaceOptions().upsert(true));
    }

    public void updateAll(Collection<T> entities) {
        for (T entity : entities) {
            update(entity);
        }
    }

    public void delete(T entity) {
        getCollection().deleteOne(eq("_id", new ObjectId(entity.getId())));
    }

    public void deleteAll(Collection<T> entities) {
        for (T entity : entities) {
            delete(entity);
        }
    }

    public boolean exists(String id) {
        Document query = new Document("_id", new ObjectId(id));
        return getCollection().countDocuments(query) > 0;
    }

    public long count() {
        return getCollection().countDocuments();
    }
}
