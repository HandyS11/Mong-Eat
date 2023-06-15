package com.mongeat.models;

import com.mongeat.models.parts.Location;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Order extends GenericModel {
    private String status;
    private double price;
    private double tip;
    private double reduction;
    private double fee;

    private List<Article> articles = new ArrayList<>();
    private User owner;
    private Location location;

    public Order() { }

    public Order(String id, String status, double price, double tip, double reduction, double fee, User owner, Location location) {
        super(id);
        this.status = status;
        this.price = price;
        this.tip = tip;
        this.reduction = reduction;
        this.fee = fee;
        this.owner = owner;
        this.location = location;
    }

    public Order(String id, String status, double price, double tip, double reduction, double fee, List<Article> articles, User owner, Location location) {
        this(id, status, price, tip, reduction, fee, owner, location);
        this.articles.addAll(articles);
    }
}
