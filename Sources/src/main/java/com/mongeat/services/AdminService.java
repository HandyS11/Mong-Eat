package com.mongeat.services;

import com.mongeat.entities.ArticleEntity;
import com.mongeat.entities.OrderEntity;
import com.mongeat.entities.RestaurantEntity;
import com.mongeat.entities.UserEntity;
import com.mongeat.repositories.BaseRepository;
import com.mongeat.stub.ArticleStub;
import com.mongeat.stub.OrderStub;
import com.mongeat.stub.RestaurantStub;
import com.mongeat.stub.UserStub;
import jakarta.inject.Singleton;

@Singleton
public class AdminService extends BaseRepository {

    public void drop(String type) {
        switch (type) {
            case "all": {
                database.drop();
                break;
            }
            case "articles": {
                database.getCollection(ArticleEntity.COLLECTION_NAME).drop();
                break;
            }
            case "users": {
                database.getCollection(UserEntity.COLLECTION_NAME).drop();
                break;
            }
            case "orders": {
                database.getCollection(OrderEntity.COLLECTION_NAME).drop();
                break;
            }
            case "restaurants": {
                database.getCollection(RestaurantEntity.COLLECTION_NAME).drop();
                break;
            }
            default: {
                System.err.println("Unknown type");
            }
        }
    }

    public boolean createStub(String type) {
        try {
            switch (type) {
                case "all": {
                    database.getCollection(ArticleEntity.COLLECTION_NAME, ArticleEntity.class).insertMany(new ArticleStub().getArticles());
                    database.getCollection(UserEntity.COLLECTION_NAME, UserEntity.class).insertMany(new UserStub().getUsers());
                    database.getCollection(RestaurantEntity.COLLECTION_NAME, RestaurantEntity.class).insertMany(new RestaurantStub().getRestaurants());
                    database.getCollection(OrderEntity.COLLECTION_NAME, OrderEntity.class).insertMany(new OrderStub().getOrders());
                    break;
                }
                case "articles": {
                    database.getCollection(ArticleEntity.COLLECTION_NAME, ArticleEntity.class).insertMany(new ArticleStub().getArticles());
                    break;
                }
                case "users": {
                    database.getCollection(UserEntity.COLLECTION_NAME, UserEntity.class).insertMany(new UserStub().getUsers());
                    break;
                }
                case "restaurants": {
                    database.getCollection(RestaurantEntity.COLLECTION_NAME, RestaurantEntity.class).insertMany(new RestaurantStub().getRestaurants());
                    break;
                }
                case "orders": {
                    database.getCollection(OrderEntity.COLLECTION_NAME, OrderEntity.class).insertMany(new OrderStub().getOrders());
                    break;
                }
                default: {
                    System.err.println("Unknown type");
                    return false;
                }
            }
            return true;
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return false;
        }
    }

    public boolean setup() {
        drop("all");
        return createStub("all");
    }
}
