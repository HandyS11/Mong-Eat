package com.mongeat.models;

import com.mongeat.models.parts.Location;
import io.quarkus.runtime.annotations.RegisterForReflection;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

/**
 * Order
 */
@Getter
@Setter
@RegisterForReflection
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

    /**
     * @param id Id of the order
     * @param status Status of the order
     * @param price Price of the order
     * @param tip Tip of the order
     * @param reduction Reduction of the order
     * @param fee Fee of the order
     * @param owner Owner of the order
     * @param location Location of the order
     */
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

    /**
     * @param id Id of the order
     * @param status Status of the order
     * @param price Price of the order
     * @param tip Tip of the order
     * @param reduction Reduction of the order
     * @param fee Fee of the order
     * @param articles Articles of the order
     * @param owner Owner of the order
     * @param location Location of the order
     */
    public Order(String id, String status, double price, double tip, double reduction, double fee, List<Article> articles, User owner, Location location) {
        this(id, status, price, tip, reduction, fee, owner, location);
        this.articles.addAll(articles);
    }
}
