package com.mongeat.models.add;

import com.mongeat.models.parts.Location;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class NewOrder {
    private String status;
    private double price;
    private double tip;
    private double reduction;
    private double fee;

    private List<String> articles = new ArrayList<>();
    private String owner;
    private Location location;

    public NewOrder() { }

    public NewOrder(String status, double price, double tip, double reduction, double fee, String owner, Location location) {
        this.status = status;
        this.price = price;
        this.tip = tip;
        this.reduction = reduction;
        this.fee = fee;
        this.owner = owner;
        this.location = location;
    }

    public NewOrder(String status, double price, double tip, double reduction, double fee, List<String> articles, String owner, Location location) {
        this(status, price, tip, reduction, fee, owner, location);
        this.articles.addAll(articles);
    }
}
