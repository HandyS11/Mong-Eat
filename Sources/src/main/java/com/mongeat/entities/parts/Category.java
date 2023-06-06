package com.mongeat.entities.parts;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class Category {
    @NonNull
    private String name;
    @NonNull
    private String image;
}
