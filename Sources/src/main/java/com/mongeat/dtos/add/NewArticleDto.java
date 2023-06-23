package com.mongeat.dtos.add;

import lombok.Getter;
import lombok.Setter;

/**
 * DTO for adding a new article
 */
@Getter
@Setter
public class NewArticleDto {
    private String name;
    private String image;
    private double price;
}
