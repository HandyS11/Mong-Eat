package com.mongeat.repositories;

import com.mongeat.entities.OrderEntity;
import com.mongodb.client.MongoCollection;
import jakarta.inject.Singleton;

@Singleton
public class OrderRepository extends GenericRepository<OrderEntity> {

    @Override
    public MongoCollection<OrderEntity> getCollection() {
        return database.getCollection(OrderEntity.COLLECTION_NAME, OrderEntity.class);
    }
}
