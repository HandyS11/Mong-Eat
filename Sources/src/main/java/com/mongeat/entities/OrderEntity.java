package com.mongeat.entities;

import com.mongeat.entities.parts.LocationEntity;
import lombok.Getter;
import lombok.Setter;
import org.bson.types.ObjectId;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class OrderEntity extends GenericEntity {
    public static final String COLLECTION_NAME = "orders";

    private String status;
    private double price;
    private double tip;
    private double reduction;
    private double fee;

    private List<String> articles = new ArrayList<>();
    private String owner;
    private LocationEntity location;

    public OrderEntity() {
        super(new ObjectId().toHexString());
    }

    public OrderEntity(String id, String status, double price, double tip, double reduction, double fee, String owner, LocationEntity location) {
        super(id);
        this.status = status;
        this.price = price;
        this.tip = tip;
        this.reduction = reduction;
        this.fee = fee;
        this.owner = owner;
        this.location = location;
    }

    public OrderEntity(String id, String status, double price, double tip, double reduction, double fee, List<String> articles, String owner, LocationEntity location) {
        this(id, status, price, tip, reduction, fee, owner, location);
        this.articles.addAll(articles);
    }
}
