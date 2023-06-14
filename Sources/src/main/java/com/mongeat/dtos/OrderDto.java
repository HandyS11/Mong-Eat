package com.mongeat.dtos;

import com.mongeat.entities.parts.Location;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class OrderDto {
    private String id;
    private String status;
    private double price;
    private double tip;
    private double reduction;
    private double fee;

    private List<String> articles = new ArrayList<>();
    private String owner;
    private Location location;
}
