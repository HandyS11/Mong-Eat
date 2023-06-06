package com.mongeat.entities.parts;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class Address {
    @NonNull
    private String country;
    @NonNull
    private String city;
    @NonNull
    private String road;
}
