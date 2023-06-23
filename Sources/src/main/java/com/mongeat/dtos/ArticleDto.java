package com.mongeat.dtos;

import lombok.Getter;
import lombok.Setter;

/**
 * DTO for article
 */
@Getter
@Setter
public class ArticleDto extends GenericDto {
    private String name;
    private String image;
    private double price;
}
