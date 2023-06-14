package com.mongeat.dtos;

import com.mongeat.dtos.parts.CategoryDto;
import com.mongeat.dtos.parts.LocationDto;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class RestaurantDto extends GenericDto {
    private String id;
    private String name;
    private String image;
    private double rate;

    private List<ArticleDto> articles = new ArrayList<>();
    private List<CategoryDto> categories = new ArrayList<>();
    private LocationDto location;
}
