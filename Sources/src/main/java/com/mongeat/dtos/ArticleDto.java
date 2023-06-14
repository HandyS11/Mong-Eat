package com.mongeat.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ArticleDto {
    private String id;
    private String name;
    private String image;
    private double price;
}
