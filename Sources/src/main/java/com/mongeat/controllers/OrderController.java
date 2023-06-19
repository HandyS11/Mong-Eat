package com.mongeat.controllers;

import com.mongeat.dtos.OrderDto;
import com.mongeat.dtos.add.NewOrderDto;
import com.mongeat.entities.OrderEntity;
import com.mongeat.mappers.OrderMapper;
import com.mongeat.mappers.add.NewOrderMapper;
import com.mongeat.models.Order;
import com.mongeat.models.add.NewOrder;
import com.mongeat.services.OrderService;
import jakarta.annotation.PostConstruct;
import jakarta.inject.Inject;
import jakarta.ws.rs.Path;

@Path("/orders")
public class OrderController extends GenericController<OrderDto, NewOrderDto, Order, NewOrder, OrderEntity> {

    @Inject
    OrderService orderService;

    @PostConstruct
    public void init() {
        setService(orderService);
        setMapper(new OrderMapper());
        setPostMapper(new NewOrderMapper());
    }
}
