package com.mongeat.converters;

import com.mongeat.converters.parts.LocationConverter;
import com.mongeat.entities.OrderEntity;
import com.mongeat.models.GenericModel;
import com.mongeat.models.Order;

import java.util.stream.Collectors;

public class OrderConverter implements IConverter<Order, OrderEntity> {
    @Override
    public OrderEntity toEntity(Order object) {
        OrderEntity orderEntity = new OrderEntity();
        orderEntity.setId(object.getId());
        orderEntity.setStatus(object.getStatus());
        orderEntity.setPrice(object.getPrice());
        orderEntity.setTip(object.getTip());
        orderEntity.setReduction(object.getReduction());
        orderEntity.setFee(object.getFee());
        orderEntity.setArticles(object.getArticles().stream().map(GenericModel::getId).collect(Collectors.toList()));
        orderEntity.setOwner(object.getOwner().getId());
        orderEntity.setLocation(LocationConverter.toEntity(object.getLocation()));
        return orderEntity;
    }

    @Override
    public Order toModel(OrderEntity object) {
        Order order = new Order();
        order.setId(object.getId());
        order.setStatus(object.getStatus());
        order.setPrice(object.getPrice());
        order.setTip(object.getTip());
        order.setReduction(object.getReduction());
        order.setFee(object.getFee());
        // impossible :/                                yet :)
        // impossible :/                                yet :)
        order.setLocation(LocationConverter.toModel(object.getLocation()));
        return order;
    }
}
