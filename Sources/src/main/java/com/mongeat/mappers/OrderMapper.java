package com.mongeat.mappers;

import com.mongeat.dtos.OrderDto;
import com.mongeat.mappers.parts.LocationMapper;
import com.mongeat.models.Order;

import java.util.stream.Collectors;

public class OrderMapper {

    public static Order mapToOrder(OrderDto orderDto) {
        Order order = new Order();
        order.setId(orderDto.getId());
        order.setStatus(orderDto.getStatus());
        order.setPrice(orderDto.getPrice());
        order.setTip(orderDto.getTip());
        order.setReduction(orderDto.getReduction());
        order.setFee(orderDto.getFee());
        order.setArticles(orderDto.getArticles().stream().map(ArticleMapper::mapToArticle).collect(Collectors.toList()));
        order.setOwner(UserMapper.mapToUser(orderDto.getOwner()));
        order.setLocation(LocationMapper.mapToLocation(orderDto.getLocation()));
        return order;
    }

    public static OrderDto mapToOrderDto(Order order) {
        OrderDto orderDto = new OrderDto();
        orderDto.setId(order.getId());
        orderDto.setStatus(order.getStatus());
        orderDto.setPrice(order.getPrice());
        orderDto.setTip(order.getTip());
        orderDto.setReduction(order.getReduction());
        orderDto.setFee(order.getFee());
        orderDto.setArticles(order.getArticles().stream().map(ArticleMapper::mapToArticleDto).collect(Collectors.toList()));
        orderDto.setOwner(UserMapper.mapToUserDto(order.getOwner()));
        orderDto.setLocation(LocationMapper.mapToLocationDto(order.getLocation()));
        return orderDto;
    }
}
