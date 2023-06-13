package com.mongeat.services;

import com.mongeat.entities.Article;
import com.mongeat.entities.Order;
import com.mongeat.entities.Restaurant;
import com.mongeat.entities.User;
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
                database.getCollection(Article.COLLECTION_NAME).drop();
                break;
            }
            case "users": {
                database.getCollection(User.COLLECTION_NAME).drop();
                break;
            }
            case "orders": {
                database.getCollection(Order.COLLECTION_NAME).drop();
                break;
            }
            case "restaurants": {
                database.getCollection(Restaurant.COLLECTION_NAME).drop();
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
                    database.getCollection(Article.COLLECTION_NAME, Article.class).insertMany(new ArticleStub().getArticles());
                    database.getCollection(User.COLLECTION_NAME, User.class).insertMany(new UserStub().getUsers());
                    database.getCollection(Restaurant.COLLECTION_NAME, Restaurant.class).insertMany(new RestaurantStub().getRestaurants());
                    database.getCollection(Order.COLLECTION_NAME, Order.class).insertMany(new OrderStub().getOrders());
                    break;
                }
                case "articles": {
                    database.getCollection(Article.COLLECTION_NAME, Article.class).insertMany(new ArticleStub().getArticles());
                    break;
                }
                case "users": {
                    database.getCollection(User.COLLECTION_NAME, User.class).insertMany(new UserStub().getUsers());
                    break;
                }
                case "restaurants": {
                    database.getCollection(Restaurant.COLLECTION_NAME, Restaurant.class).insertMany(new RestaurantStub().getRestaurants());
                    break;
                }
                case "orders": {
                    database.getCollection(Order.COLLECTION_NAME, Order.class).insertMany(new OrderStub().getOrders());
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
