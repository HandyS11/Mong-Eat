package com.mongeat.entities;

import lombok.Getter;
import lombok.Setter;
import org.bson.codecs.pojo.annotations.BsonId;

import java.util.Objects;

@Getter
@Setter
public abstract class GenericEntity {
    @BsonId
    private String id;

    public GenericEntity(String id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GenericEntity entity = (GenericEntity) o;
        return Objects.equals(id, entity.id);
    }
}
