package com.mongeat.mappers.add;

import com.mongeat.dtos.add.NewOrderDto;
import com.mongeat.mappers.IMapper;
import com.mongeat.mappers.parts.LocationMapper;
import com.mongeat.models.add.NewOrder;

public class NewOrderMapper implements IMapper<NewOrder, NewOrderDto> {

    @Override
    public NewOrderDto toDto(NewOrder object) {
        NewOrderDto orderDto = new NewOrderDto();
        orderDto.setStatus(object.getStatus());
        orderDto.setPrice(object.getPrice());
        orderDto.setTip(object.getTip());
        orderDto.setReduction(object.getReduction());
        orderDto.setFee(object.getFee());
        orderDto.setArticles(object.getArticles());
        orderDto.setOwner(object.getOwner());
        orderDto.setLocation(LocationMapper.toDto(object.getLocation()));
        return orderDto;
    }

    @Override
    public NewOrder toModel(NewOrderDto object) {
        NewOrder order = new NewOrder();
        order.setStatus(object.getStatus());
        order.setPrice(object.getPrice());
        order.setTip(object.getTip());
        order.setReduction(object.getReduction());
        order.setFee(object.getFee());
        order.setArticles(object.getArticles());
        order.setOwner(object.getOwner());
        order.setLocation(LocationMapper.toModel(object.getLocation()));
        return order;
    }
}
