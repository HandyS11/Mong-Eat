package com.mongeat.entities;

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
