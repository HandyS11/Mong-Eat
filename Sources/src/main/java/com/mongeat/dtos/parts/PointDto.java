package com.mongeat.dtos.parts;

import io.quarkus.runtime.annotations.RegisterForReflection;
import lombok.Getter;
import lombok.Setter;

/**
 * DTO for point
 */
@Getter
@Setter
@RegisterForReflection
public class PointDto {
    private double x;
    private double y;
}
