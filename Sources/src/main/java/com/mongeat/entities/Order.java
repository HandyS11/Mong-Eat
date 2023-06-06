package com.mongeat.entities;

import com.mongeat.entities.parts.Location;
import lombok.NonNull;

import java.util.ArrayList;
import java.util.List;

public class Order extends GenericEntity {
    public static final String COLLECTION_NAME = "orders";
    @NonNull
    private String status;
    @NonNull
    private double price;
    @NonNull
    private double tip;
    @NonNull
    private double reduction;
    @NonNull
    private double fee;

    @NonNull
    private List<String> articles = new ArrayList<>();
    @NonNull
    private String owner;
    @NonNull
    private Location location;

    public Order(String id, String status, double price, double tip, double reduction, double fee, String owner, Location location) {
        super(id);
        this.status = status;
        this.price = price;
        this.tip = tip;
        this.reduction = reduction;
        this.fee = fee;
        this.owner = owner;
        this.location = location;
    }

    public Order(String id, String status, double price, double tip, double reduction, double fee, List<String> articles, String owner, Location location) {
        this(id, status, price, tip, reduction, fee, owner, location);
        this.articles.addAll(articles);
    }
}
