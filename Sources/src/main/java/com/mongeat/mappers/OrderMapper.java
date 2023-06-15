package com.mongeat.mappers;

import com.mongeat.dtos.OrderDto;
import com.mongeat.mappers.parts.LocationMapper;
import com.mongeat.models.Order;

import java.util.stream.Collectors;

public class OrderMapper implements IMapper<Order, OrderDto> {
    ArticleMapper articleMapper = new ArticleMapper();
    UserMapper userMapper = new UserMapper();

    @Override
    public OrderDto toDto(Order object) {
        OrderDto orderDto = new OrderDto();
        orderDto.setId(object.getId());
        orderDto.setStatus(object.getStatus());
        orderDto.setPrice(object.getPrice());
        orderDto.setTip(object.getTip());
        orderDto.setReduction(object.getReduction());
        orderDto.setFee(object.getFee());
        orderDto.setArticles(object.getArticles().stream().map(article -> articleMapper.toDto(article)).collect(Collectors.toList()));
        orderDto.setOwner(object.getOwner() != null ? userMapper.toDto(object.getOwner()) : null);
        orderDto.setLocation(LocationMapper.toDto(object.getLocation()));
        return orderDto;
    }

    @Override
    public Order toModel(OrderDto object) {
        Order order = new Order();
        order.setId(object.getId());
        order.setStatus(object.getStatus());
        order.setPrice(object.getPrice());
        order.setTip(object.getTip());
        order.setReduction(object.getReduction());
        order.setFee(object.getFee());
        order.setArticles(object.getArticles().stream().map(article -> articleMapper.toModel(article)).collect(Collectors.toList()));
        order.setOwner(userMapper.toModel(object.getOwner()));
        order.setLocation(LocationMapper.toModel(object.getLocation()));
        return order;
    }
}
