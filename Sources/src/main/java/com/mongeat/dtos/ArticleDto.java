package com.mongeat.dtos;

import io.quarkus.runtime.annotations.RegisterForReflection;
import lombok.Getter;
import lombok.Setter;

/**
 * DTO for article
 */
@Getter
@Setter
@RegisterForReflection
public class ArticleDto extends GenericDto {
    private String name;
    private String image;
    private double price;
}
