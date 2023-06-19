package com.mongeat.converters.add;

import com.mongeat.converters.IConverter;
import com.mongeat.converters.parts.LocationConverter;
import com.mongeat.entities.OrderEntity;
import com.mongeat.models.add.NewOrder;

public class NewOrderConverter implements IConverter<NewOrder, OrderEntity> {

    @Override
    public OrderEntity toEntity(NewOrder object) {
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

    @Override
    public NewOrder toModel(OrderEntity object) {
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
