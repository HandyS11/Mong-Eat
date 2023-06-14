package com.mongeat.dtos;

import com.mongeat.entities.parts.Category;
import com.mongeat.entities.parts.Location;
import org.bson.types.ObjectId;

import java.util.ArrayList;
import java.util.List;

public class RestaurantDto {
    private String id;
    private String name;
    private String image;
    private double rate;

    private List<String> articles = new ArrayList<>();
    private List<Category> categories = new ArrayList<>();
    private Location location;
}
