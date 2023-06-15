package com.mongeat.dtos;

import com.mongeat.dtos.parts.LocationDto;
import com.mongeat.entities.parts.LocationEntity;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class OrderDto extends GenericDto {
    private String status;
    private double price;
    private double tip;
    private double reduction;
    private double fee;

    private List<ArticleDto> articles = new ArrayList<>();
    private UserDto owner;
    private LocationDto location;
}
