package com.mongeat.dtos.parts;

import io.quarkus.runtime.annotations.RegisterForReflection;
import lombok.Getter;
import lombok.Setter;

/**
 * DTO for category
 */
@Getter
@Setter
@RegisterForReflection
public class CategoryDto {
    private String name;
    private String image;
}
