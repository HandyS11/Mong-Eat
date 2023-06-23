package com.mongeat.dtos.add;

import com.mongeat.dtos.parts.LocationDto;
import io.quarkus.runtime.annotations.RegisterForReflection;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

/**
 * DTO for adding a new order
 */
@Getter
@Setter
@RegisterForReflection
public class NewOrderDto {
    private String status;
    private double price;
    private double tip;
    private double reduction;
    private double fee;

    private List<String> articles = new ArrayList<>();
    private String owner;
    private LocationDto location;
}
