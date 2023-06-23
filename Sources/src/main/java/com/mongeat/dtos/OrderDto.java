package com.mongeat.dtos;

import com.mongeat.dtos.parts.LocationDto;
import io.quarkus.runtime.annotations.RegisterForReflection;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

/**
 * DTO for order
 */
@Getter
@Setter
@RegisterForReflection
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
