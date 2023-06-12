package com.mongeat.entities;

import org.bson.codecs.pojo.annotations.BsonId;
import org.bson.types.ObjectId;

import java.util.Objects;

public abstract class GenericEntity {
    @BsonId
    private ObjectId id;

    public GenericEntity(String id) {
        this.id = new ObjectId(id);
    }

    public String getId() {
        return id.toHexString();
    }

    public void setId(String id) {
        this.id = new ObjectId(id);
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
