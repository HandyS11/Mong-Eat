package com.mongeat.entities.parts;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import lombok.RequiredArgsConstructor;

@Getter
@Setter
@RequiredArgsConstructor
public class Location {
    @NonNull
    private Point point;
    @NonNull
    private Address address;
}
