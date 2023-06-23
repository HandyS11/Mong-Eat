package com.mongeat.converters.add;

import com.mongeat.converters.IConverter;
import com.mongeat.converters.parts.LocationConverter;
import com.mongeat.entities.OrderEntity;
import com.mongeat.models.add.NewOrder;

/**
 * Converts a NewOrder to an OrderEntity
 */
public class NewOrderConverter implements IConverter<NewOrder, OrderEntity> {

    /**
     * Converts a NewOrder object to an OrderEntity object.
     *
     * @param object The NewOrder object to convert.
     * @return The OrderEntity object.
     */
    @Override
    public OrderEntity toEntity(NewOrder object) {
        if (object == null) {
            return null;
        }
        OrderEntity orderEntity = new OrderEntity();
        orderEntity.setStatus(object.getStatus());
        orderEntity.setPrice(object.getPrice());
        orderEntity.setTip(object.getTip());
        orderEntity.setReduction(object.getReduction());
        orderEntity.setFee(object.getFee());
        orderEntity.setArticles(object.getArticles());
        orderEntity.setOwner(object.getOwner());
        orderEntity.setLocation(LocationConverter.toEntity(object.getLocation()));
        return orderEntity;
    }

    /**
     * Converts an OrderEntity object to a NewOrder object.
     *
     * @param object The OrderEntity object to convert.
     * @return The NewOrder object.
     */
    @Override
    public NewOrder toModel(OrderEntity object) {
        if (object == null) {
            return null;
        }
        NewOrder order = new NewOrder();
        order.setStatus(object.getStatus());
        order.setPrice(object.getPrice());
        order.setTip(object.getTip());
        order.setReduction(object.getReduction());
        order.setFee(object.getFee());
        order.setArticles(object.getArticles());
        order.setOwner(object.getOwner());
        order.setLocation(LocationConverter.toModel(object.getLocation()));
        return order;
    }
}
