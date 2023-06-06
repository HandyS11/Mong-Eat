package com.mongeat.repositories;

import com.mongeat.entities.Order;
import com.mongodb.client.MongoCollection;

public class OrderRepository extends BaseRepository<Order> {

    @Override
    public MongoCollection<Order> getCollection() {
        return database.getCollection(Order.COLLECTION_NAME, Order.class);
    }
}
