package com.mongeat.dtos;

import com.mongeat.dtos.parts.LocationDto;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class UserDto extends GenericDto {
    private String firstName;
    private String lastName;
    private List<LocationDto> locations = new ArrayList<>();
}
