package com.mongeat.dtos.add;

import io.quarkus.runtime.annotations.RegisterForReflection;
import lombok.Getter;
import lombok.Setter;

/**
 * DTO for adding a new article
 */
@Getter
@Setter
@RegisterForReflection
public class NewArticleDto {
    private String name;
    private String image;
    private double price;
}
