package com.mongeat.dtos.add;

import com.mongeat.dtos.parts.LocationDto;
import io.quarkus.runtime.annotations.RegisterForReflection;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

/**
 * DTO for adding a new user
 */
@Getter
@Setter
@RegisterForReflection
public class NewUserDto {
    private String firstName;
    private String lastName;
    private List<LocationDto> locations = new ArrayList<>();
}
