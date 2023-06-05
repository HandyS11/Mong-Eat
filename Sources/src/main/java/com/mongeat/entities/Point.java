package com.mongeat.entities;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class Point {
    @NonNull
    private String x;
    @NonNull
    private String y;
}
