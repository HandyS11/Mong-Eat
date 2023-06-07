package com.mongeat.entities.parts;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class Point {
    @NonNull
    private Double x;
    @NonNull
    private Double y;
}
