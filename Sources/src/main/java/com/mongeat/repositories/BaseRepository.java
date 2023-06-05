package com.mongeat.repositories;

import com.mongeat.entities.GenericEntity;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.ReplaceOptions;
import org.bson.Document;
import org.bson.types.ObjectId;

import java.util.ArrayList;
import java.util.Collection;

import static com.mongodb.client.model.Filters.eq;

public abstract class BaseRepository<T extends GenericEntity> {
    final String DB_NAME = "MongEat";
    final String CONNECTION_STRING = "mongodb://localhost:27017";

    public MongoDatabase database = MongoClients.create(CONNECTION_STRING).getDatabase(DB_NAME);

    protected abstract MongoCollection<T> getCollection();

    public T findById(String id) {
        return getCollection().find(eq("_id", new ObjectId(id))).first();
    }

    public Collection<T> getAll() {
        return getCollection().find().into(new ArrayList<>());
    }

    public void insertOrUpdate(T entity) {
        getCollection().replaceOne(
                eq("_id", new ObjectId(entity.getId())),
                entity,
                new ReplaceOptions().upsert(true));
    }

    public void insertOrUpdateAll(Collection<T> entities) {
        for (T entity : entities) {
            insertOrUpdate(entity);
        }
    }

    public void delete(T entity) {
        getCollection().deleteOne(eq("_id", new ObjectId(entity.getId())));
    }

    public boolean exists(String id) {
        Document query = new Document("_id", new ObjectId(id));
        return getCollection().countDocuments(query) > 0;
    }
}
