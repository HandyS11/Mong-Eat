package com.mongeat.entities;

import lombok.Getter;
import lombok.Setter;
import lombok.RequiredArgsConstructor;

@Getter
@Setter
@RequiredArgsConstructor
public class Location {
    private Point point;
    private Address address;
}
