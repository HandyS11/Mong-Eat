package com.mongeat.dtos.add;

import com.mongeat.dtos.parts.CategoryDto;
import com.mongeat.dtos.parts.LocationDto;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

/**
 * DTO for adding a new restaurant
 */
@Getter
@Setter
public class NewRestaurantDto {
    private String name;
    private String image;
    private double rate;

    private List<String> articles = new ArrayList<>();
    private List<CategoryDto> categories = new ArrayList<>();
    private LocationDto location;
}
