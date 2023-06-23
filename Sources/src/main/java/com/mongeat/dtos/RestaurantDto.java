package com.mongeat.dtos;

import com.mongeat.dtos.parts.CategoryDto;
import com.mongeat.dtos.parts.LocationDto;
import io.quarkus.runtime.annotations.RegisterForReflection;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

/**
 * DTO for restaurant
 */
@Getter
@Setter
@RegisterForReflection
public class RestaurantDto extends GenericDto {
    private String name;
    private String image;
    private double rate;

    private List<ArticleDto> articles = new ArrayList<>();
    private List<CategoryDto> categories = new ArrayList<>();
    private LocationDto location;
}
