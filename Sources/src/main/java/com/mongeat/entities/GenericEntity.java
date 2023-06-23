package com.mongeat.entities;

import org.bson.codecs.pojo.annotations.BsonId;
import org.bson.types.ObjectId;

import java.util.Objects;

/**
 * GenericEntity
 */
public abstract class GenericEntity {
    @BsonId
    private ObjectId id;

    /**
     * @param id Id of the entity
     */
    protected GenericEntity(String id) {
        this.id = new ObjectId(id);
    }

    /**
     * @return String of the Id
     */
    public String getId() {
        return id.toHexString();
    }

    /**
     * @return ObjectId of the Id
     */
    public ObjectId getObjectId() {
        return id;
    }

    /**
     * @param id Id of the entity
     */
    public void setId(String id) {
        this.id = new ObjectId(id);
    }

    /**
     * @return the hashcode of the entity
     */
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    /**
     * @param o Object to compare
     * @return True if the object is equal to this
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GenericEntity entity = (GenericEntity) o;
        return Objects.equals(id, entity.id);
    }
}
