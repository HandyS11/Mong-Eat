package com.mongeat.controllers;

import com.mongeat.dtos.OrderDto;
import com.mongeat.entities.Order;
import com.mongeat.services.OrderService;
import jakarta.annotation.PostConstruct;
import jakarta.inject.Inject;
import jakarta.ws.rs.Path;

@Path("/orders")
public class OrderController extends GenericController<Order, OrderDto> {

    @Inject
    OrderService orderService;

    public OrderController() {
        super(OrderDto.class);
    }

    @PostConstruct
    public void init() {
        setService(orderService);
    }
}
